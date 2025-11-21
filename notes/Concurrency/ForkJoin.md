<h1> FOrk/Join</h1>

<h2> Guidelines</h2>
- uses as few threadpools
- use default threadpool
- Avoid Blocking

- fork: recursive break task into smaller independent subtask
- join: results join of each subtask

<h2> ForkJoin Pool</h2>

- implements ExecutorService
- manage worker thread
- threadpool state and performance

<h2> Algorithm</h2>

- WorkStealing
- Free threads get from head of its deque
- if deque empty gettask fromt tail of deque of busy thread or global entry queue
- work on biggest chunk to minimize threads competing for tasks

<h2> ForkJOinPool Instantiation(Java 8)</h2>

- static commonPool()
- ForkJoinPool.commonPool()
- ```
  public static ForkJoinPool = new ForkJoinPool();
  ForkJoinPool = PoolUtil.ForkJoinPool;
  ```
  <h2>ForkJoinTask<V>
- base type for tasks executed
- extend RecursiveAction or RecursiveTask<>
- compute abstract method

<h2> RecursiveAction</h2>

- create object to represent work
- select threshold
- divide work and do work

<h2>List<Action></h2>

- ```
  subtask = workLoad.subString(0,workload.length()/2);
  subtasks.add(subtask);
  ```
- ```
  @Override
  protected void compute() {
    if(workload.length() > Threshold) {
  ForkJoinTask.invokeAll(createSubTask())  --recursive
  }
  }
   ```
  
ResursiveTask<V> returns a value
- result for each subtask united in single result
- `List<RecursiveTask> task.add(new RecursiveTask(Arrays.copyOfRange(ForkJoinTask(::join))))`
- ```
  @Override
  compute(){if(arr.length()> THRESHOLD) {
  return ForkJoinTask.invokeAll(createSubtask()).stream().map(::join)
  }}

  ```
1) Create Object to represent work
2) Select threshold
3) invokeAll to commonpool returns Futuires.join() to execute
  

<h2> Submitting task to fork/join </h2>
- fork to submit
- join to execute
1) submit/create 
2) invoke()
   -invokeAll takes task as parameters return Collection of Future Objects

<h2> ParallelStream</h2>

- ParallelStream work with custom threadpool-aList.parallelStream() - ForkJoinPool.commonPool
  -  shared threadpool app under the hood

<h3> Custom ThreadPool</h3>

- ```
  ForkJoinPool = new ForkJoinPool(4); - parallelism 4: if 4 cores on CPU
  customThreadPool.submit(()-> aList.parallelStream().reduce().get())
  ```

<h3> Benefits</h3>
Do not tie-up common thread with long running task

<h3> Memory Leak</h3>

- CustomThreadPool wait for new tasks to be assigned
- `Custom ThreadPool.shutdown()` 
  - in finally block
  
<h3> CountDownLAtch</h3>

- thread to block until other threads have completed a given task
- Usage in concurrent programming
- decrement counter of countdown latch until countdown is 0
- Countdown after each thread finishes

- `run() {countDownLatch.countDown();}`
- ```
  CountDownLatch = new CountDownLatch(5);
  List<Thread thread.stream().generate(()-> new aThread(new Worker(Collections.synchronizedList(new ArrayList<>()),CountDownLatch).limit(5).collect(toList)));
  workers.forEach(Thread::start);
  countDownLatch.await();
  ```
  - ordering of thread execution
<h3> Waiting to begin</h3>
    - ```
      run() {
        readyThreadCounter.countDown();
        try{
        callingThreadBlocker.await();
      } finally {
        completedThreadCounter.countDown();
      }
      Stream.generate(()-> new Thread(new WaitingWorker(outputScraper,readyThreadCounter,callingThreadBlocker,completedThreadCounter))).limit(5).collect(workers.forEach(Thread::start));
      }
      workers.forEach(Thread::start);
      readyThreadCounter.await();
      callingThreadCOunter.await();
      completedThreadCounter.await();
      ```
      - Reproduce concurrency bug here
<h3> Terminate with Error</h3>
      - countDownLatch never reach 0 and await never terminates
        - worker threads responsible for countDown is never started
      - Deadlock , worker threads never start to decrement the count, main thread waits indefinitely

<h3> Solution</h3>
- countDownLatch.await(3L, TimeUnit.SECONDS);
- Debug concurrency issues by making thread run in parallel

<h2> Executor waiting for thread to finish</h2>
<h3>CountDownLatch</h3>
<h4>invokeAll</h4>

- returns List of Future
- Order of Future object same as list of Callable objects
- index first result is first called inex

<h2>ExecutorCompletionService</h2>

- uses supplied ExecutorService
- Executor uses a queue to store results in the order that they are finished
- ```
  for(Callable<String> callable: callables) {
    service.submit(callable);
  }
  Future<String> future = service.take()
  ```
- take
- retrieve and remove head
