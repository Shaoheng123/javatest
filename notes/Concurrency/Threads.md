<h1>Killing a Java thread</h1>

<h2>Using a Flag(Atomic)</h2>
```
private final AtomicBoolean running = new AtomicBoolean
public void stop() {
running.set(false)}
public void run() {
running.set(true)};
while(running.get()) {
try 
Thread.sleep(interval);
}
```

<h2>Atomic Operations</h2>
low-level machine instruction like compare anmd swap
for data integrity
Memory Location
expected vvalue of variable
new value to set
updates atomically value in M to B if M amtches A
multiple threads try to update sam,e value but only 1 updates,no threads get suspended
Don't need context switch
Handle CAS don't succeed

<h2> Atomic Variables</h2>

- AtomicInteger
- AtomicLong
- AtomicReference

<h2>Methods</h2>

- get() - get value from memory reading volatile variable
- incrementAndGet(): Atomically increment by one and store current value in memory
- set() writes value to memory change visible to other threads
- lazySet: eventually writes value to memory
  - nullify reference, garbage colelction not going to access
  - delay volatile write
- computeAndSet()
  - succeed true else false
- weakCompareAndSet()
  - does not create happens before ordering
  - may not see updates to other variable
<h2> Interrupting thread</h2>
  - Purpose: risk of blocking for long period or not terminating
  ```
  public void interrupt() {
  running.setFalse()
  worker.interrupt
  }
  ```
  If thread sleeping - sleep() exit with InterruptedException
- blocking call
- thread return to loop exit since running is false
- avoid stop() risk locking and memory corruption

<h2> ThreadPool</h2>

- system level threads
- context switching between threads
- save resource in multi-threaded application contain parallelism
- controls threads that execute parallel tasks
- control number of threads created and lifecycle

- code decoupled from actual implementation of thread pool
- Executors
- Executor
- ExecutorService

Executor:
single execute method to submit Runnable instance
`Executor executor = Executors.newSingleThreadExecutor()`

ExecutorService
- control progress of task and manage termination of service
- control execution using Future instance
- `ExecutorService executorService = Executors.newFixedThreadPoo()l`
- ```
  Future<String> future = executorService.submit(()->);\
  String result = future.get();
  ```
  Callable: throwexception and return value from lambda
<h2>ThreadPoolExecutor</h2>
- extensible threadpool with parameters and hooks
- corePoolkSize
- maximumPoolSize
- keepAliveTime
- pool has fixed number of core threads
- corethreads busy, internal queue full
- pool to maximumPoolSize

new FixedThreadPool
ThreadPoolExecutor threadPoolExecutor = ThreadPOolExecutor(Executor.newFixedThreadPool(n))
- if less than n, executed right away

Methods
- getPoolSize()
- getQueue().size()

<h2> Executors.newCachedThreadPool()</h2>

- grow without bounds
- dispose of after time of inactivity
- purpose : short-leved task
- 0 queuesize
- synchronous Queue
insert and remove simultaneously

Executors.newSingleThreadExecutor()
-puirpose event loop
- Core Pool SIze and maximumPoolSize == 1 
- KeepAliveTime = 0

Schedule ThreadpoolExecutor
Thread implements ScheduledExecutorService interface
schedule-run task after specified delay
Methods
- ScheduleAtFixedRate
- ScheduleAtFixedDelay

<h2>Sender-Receiver Synchronization</h2>
- Sender send a data packet to receiver
- Receriver cannot process until Sender finishers sending
- wait till Receiver process previous packet
  - ```
    public synchronized String receive() {
      while(transfer) {
    try{
    wait();}
    }catch(InterruptedException ){
      Thread.currentThread().interript()
    transfer = true;
    notifyAll();  
    }
    }
    public void run() {
      forEach(load.receive())
    sender.start();
    receiver.start();
    }
    ```
  <h2> Runnable vs Callable</h2>
<h3> Execution Mechanism</h3>

- Both interface represent task that can run by multiple thread

| Runnable                                  | Callable                                                                        |
|-------------------------------------------|---------------------------------------------------------------------------------|
| run() method no parameters or return value| generic interface contains call() method returns generic value in future object |
| Thread/Executor                           | ExecutorService                                                                 |
|Future = executorService.submit(new EventLoggingTask())|Future<Integer> = executorService.submit(task);|

<h3> Exception Handling </h3>

|Runnable| Callable                    |
|--|-----------------------------|
|no way to handle exception| Future.get()                |
|| ExecutionException getCause |

|wait| sleep                                                  |
|--|--------------------------------------------------------|
|can only be called from synchronized block| can be called from anywhere                            |
|releases lock on object so another thread can use| Thread.sleep() pauses thread and does not release lock |

<h3>Waking</h3>

- notify or notifyAll()
- sleep(get started unless interrupted)

<h3>Thread.join()</h3>

- inter-thread synchronizatrion
- calling thread wait till referenced thread terminate
- throws InterruptedException if referneced thread terminate
- returns immediatelyt if terminate or not started
- Timeout
- Thread.join(long millis) 
  - waits for how long
  - 0 forever waiting 
  - return to caller method if not finished

<h2> Synchronization</h2>

- All actions before any thread returns from join()
- when t1 calls in t2.join
- All changes by t2 visible in t1
- when call t2.join() 
- synchronize 
- ```
  t4.start();
  do{ t4.join()}
    while t4.processing(count>0)()
  ```
- t4.start()

<h2> Mutex</h2>

- Multi-threaded across shared resource at the same time
- Race condition-synchronize access
- acquire Mutex, mutex block until mutex release, thread release

Usage:

-synchronize the threads

<h3>synchronized keyword</h3>
- implement mutex
- restrict access of critical section to only 1 threead
- Each object has intristic lock
- When thread invokes synchronized method or schronized block
- automatically acquire lock
- released when complete or exception thrown
- |Method|Block|
  |--|--|
- |public synchronized int method()|public int method(){synchronized(mutex)}|

<h3> ReEntrantLock(Java 1.5) </h3>

private ReentrantLock mutex = new ReentrantLock()
try{
mutex.lock()
} finally {mutex.release();}

Semaphore(Java 1.5)

- Fixed number of  thread access critical section
- Semaphore mutex = new Semaphore();
- mutex.acquire
- finally{mutex.release()}

<h2> ThreadPoolTaskExecutor </h2>

|corePoolSize|MaxPoolSize|
|--|--|
|minimum number of workers to keep aliver without timing out| maximum number of threads|
|Delegates setting value to ThreadPoolExecutor|Delegates setting property to ThreadPoolExecutor|
|allow CoreThreadTimeout -> corePoolsize == 0| 
||Create new thread if number of items exceed queueCapacity|
```
public void startThread(ThreadPoolTaskExecutor taskExecutor,CountDownLatch countDownLatch) {
  taskExecutor.executor(()->{
    try{
    Thread.sleep(100L * ThreadLocalRandom.current.nextInt(100))}
  })
} finally {
  countDownLatch.countDown();
}

```
- corePoolSize:5 sets the number of core threads in threadpool even if idle,create threads up to until tasks are submitted
- When queue is unbounded, new tasks added to the queue after the corePoolSize threads are busy
- No threads beyond the corePoolSize will be created
- `this.startThreads(taskExecutor,countDownLatch,20);`
- if(queueCapacity == 0 && 10 task started
  - 10 threads in ThreadPoolTaskExecutor)

<h2> Advanced Concurrency</h2>

- Daemon threads are background threads lower priority
- terminate after all user threads finish
<h3> Creating Daemon thread</h3>
- ```
  NewThread daemonThread = new NewThread();
  daemonThread.setDaemon(true);
  daemonThread.start();
  ```
- Thread inherit daemon status of thread that created it
- main thread is a user thread, any thread in main threads are user threads
- setDaemon 
  - only after Thread created
  - Thread running throws IllegalThreadStateException
  - `isDaemon` to check if daemon Thread

<h2> Difference between Daemon and User Thread</h2>

|          | User Thread                         | Daemon Thread                             |
|----------|-------------------------------------|-------------------------------------------|
|JVM| run as long as user thread is alive | exits when only daemon threads are running |
| Use Case | Application Logic, Program flow     | Garbage Collector, monitoring thread      |
| LifeCycle | Manually terminate                  | Auto when all user thread finish          |
|Calling Thread|                                           | join can prevent JVM exit and Application shutdown |

<h2> ExecutorService</h2>

pool of threads and API to assign task
<h3> Instantiating Executor</h3>

<h3>Factory Methods</h3>

- `ExecutorService executor = Executors.newFixedThreadPool(n)`
- how many threads
<h2> ExecutorService</h2>
- ```
  ExecutorService executorService = new ThreadPoolExecutor((Runnable); 1,1,0L,TimeUnit.MILLISECONDS, new LinkedBlockingQueue)
  ```
  <h2> Assign Task to ExecutorService</h2>
- Runnable and Callable
- `execute()` Executor interface
  - void method cannot check status
- submit() - callable or runnable task and return Future
- `invokeAny()`
- assigns a collection of task and returns one result if any succeed
- `invokeAll()`
  - assigns collection of task returns all result as a list of objects of type future(`List<Future<String>>`)
  <h2>Shutting down ExecutorService</h2>
  - waiting JVM could keep JVM running
  - executorService.shutdown()
    - stop accepting new task and shutdown after all running tasks ends
  - executorService.shutDownNow()
    -tries to shutdown immediately
  - return List<Runnable> waiting to be processed

<h2> Best Practice</h2>

- executorService.shutDown();
- ```
  try{
    if(!executorService.awaitTermination(800,TimeUnit.MILLISECOND))
    executorService.shutdownNow();
  } catch(InterruptedException e) {
    executorService.shutDownNow();
  }
  ```
  <h2> Future Interface</h2>

get - returns result of Callable execution or null for Runnable
- `Future<String> = executorService.submit();`
- block execution until task properly executes and result available
- `future.get(200,TimeUnit.MILLISECONDS)`;
- TIMEOUTException if execution period longer
- isDOne()
- future.cancel()
- future.isCancelled

<h2> ScheduledExecutorService</h2>

- Instantiation
- Executors.newSingleThreadScheduledExecutor();
- scheduled() ,methods
- `Future<String = executorService.schedule(callableTask,1,TimeUnit.MILLISECOND)`;
- executorService.scheduleAtFixedRate(RunnableTask, 100,450,TimeUnit)
- wait for current ask complete before starting next
<h2> ExecutorService vs fork/join</h2>
- Executor - more control, control generated threads and granualarity of each thread.
- process independent tasks, 1 thread for 1 task
- fork/join
  
- | ExecutorService |fork/join|
  |-----------------|--|
  | more control    |simplicity and performance|
  |control generated threads and granularity of each thread||
  |process independent tasks||
  |1 thread for each task||

<h2> ThreadLocalRandom(JDK7)</h2>

- generate random numbers in a multi-threaded environment
- avoid concurrent access
- random numbner not affected by other thread
- cannot setSeed

<h3> Thread Contention</h3>

- each thread own instance of random and confined seed

<h3> Generate Random values</h3>

- ```
  ThreadLocalRandom.current().nextGaussian()- noprmally distibution
  ```
  - more efficient than random
<h3> Implementaion(Java 8)</h3>
- Instead of dedicated Random instance
- maintain seed value
- threadLocalRandomSeed
- threadLocalRandomSeed 
  - fork/join pool
- optimization:@Contented to avoid false sharing padding to isolate contented variables
- `sun.misc.unsafe`: update variables
- avoid extra hashtable lookups with ThreadLOcal implementation 

<h2>Thread Safety</h2>
<h3>stateless Implementation</h3>
- Factorial() is stateless deterministic
- does not rely on external state or maintain state
- Thread safe and called by multiple threads as output not 1.

<h3> Immutable Implementaion</h3>
- Making classes immutable(value cannot change)
- declarte classes and fields private and final and no setters

<h3> Thread-Local FIelds</h3>

- Define private fields in Thread classes that do not share state between threads to maintain state
- Each Thread local field accessed by thread using getter/setter gets independently initialized copy of the field

<h3> Synchronized Collections</h3>

- Collections.synchronizedCollection(new ArrayList);
- use intrinsic locking in each method. Methods accessed by only 1 thread at a time 
- block until first method unlocked

<h3> COncurrent Collections</h3>

- Dividing data into segments, different map segment
- multiple threadfs locks different map segments
- more performant
- Only COllection thread-safe, not the contents

<h3> Atomic Objects</h3>

- Atomic operation
- thread safe without synchronization

<h3> Synchronized Method</h3>

- only 1 thread access synchronized method while blocking access from other thread
- ```
  public synchronized void
  ```
  synchronized rely on getting access and releasing intristic locks on objects

<h3> Synchronized Statement</h3>

synchronized(this) - specify object providing lock
- synchronize relevant as synchronzation is expensive
- ```
  private final Object lock() {
    incrementCounter() { synchronized(lock)}
  }
  ```
- Secutiry at log level but DOS could caused a deadlock

<h3> Cavaets</h3>

- Avoid using string as lock
  - String interning may cause class to share the same lock
- Avoid Cacheable or reusable objects as l;ocks
  - Integer.valueOfCache small numbers

<h3> Volatile</h3>

instruct JVM to store counter and all variables in given thread, read and write to main memory instead of CPU cache

<h3> REENTRANTLOCKS</h3>

- prevent queued threads from resource starvation
- priority to longest waiting thread

<h3> READWRITELOCk</h3>
- ReentrantReadWriteLock
  - pair of associated locks, one for reading and 1 for writing
  - can read many threads but cannot read while writing
  
