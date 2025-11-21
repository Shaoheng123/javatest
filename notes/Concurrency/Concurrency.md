<h1> Concurrency</h1>

<h2> Tools for concurrency</h2>

Executor
- ExecutorService
- ScheduledExecutor Service
- Future
- Countdown latch
- CyclicBarrier

ThreadFactory
- BlockingQueue
- DelayQueue
- Locks
- Phaser

Executor
- interface for object that executes task
- ```
  public class Invoker implements Executor
  @Override
  public void execute(Runnable r) {
    r.run();
  }
  ```
  Decouple task execution flow
- ```
  public void execute() {
  Executor executor = new Invoker();
  executor.execute(()) -> {};
  }
  ```
  RejectedExecutionException
- Executor has been Shut dDown
    - task are rejected if they are submitted to executor service after shutdown() or shutdownNow() methods have been called
    - executor are no longer accepting new work
- Executor capacity is reached
  - maximum number of threads are busy and task cannot be buffered and rejected
  - queue is full and are rejected

<h2>ExecutorService</h2>

In memory queue and executes based on threads
```
public class Task implements Runnable {

  @Override
  public void run() {
  ExecutorService executor = Executors.newFixedThreadPool}
  }
```
`Future<?> future = executor.submit(()-> );`
- `service.shutDownNow()`;
- `service.shutDown()`
```
try{
  executor.awaitTermination(time,TimeUnit.nanoseconds);
} catch(InterruptedException e ) {

}
```
ScheduledExecutorService

ScheduledExecutorService = Executors.newScheduledThreadPool();
scheduler.schedule() -> scheduler.scheduleWithFixedDelay(Runnable, initialDelay,period)

creates and executes periodic action after initial delay and reported by

<h2> Future </h2>
- result of any asynchronous operation
- ExecutorService
- check if ready
  - ```
    if(future.isDone&&!future.isCancelled) {
      Timeout.TimeoutException
    }
    ```

<h3> Countdown latch(JDK 5)</h3>

- Block all threads until operation completes
- decrement until all threads complete
```
CountDownLatch latch = new CountDownLatch(counter);
new Thread(()->{latch.countDown()}).start();
latch.await();
```

<h3>CyclicBarrier</h3>

- Allows multiple threads to wait for each other using await()
```
public class Task implements Runnable {
private CyclicBarrier;
Cyclic Barrier cyclicBarrier= new CyclicBarrier(2);
new Thread((c)->cyclicBarrier.await(1,3).start());
}
```

Check if any threads interrupted during execution
```
@Override
public void run() {
try {
  barrier.await();
  if(!cyclicBarrier.isBroken()){
  t1.start);
  t2.start();
  }
}
```
<h2> Semaphore</h2>

- used for blocking thread level access to physical or logical semaphore
- semaphore cotnains permit
- check if can access thread
- tryAcquire method
- if succeed permit counter decreases
- cannot go into critical section
- when execution released, permit increase

Methods: semaphore: available permits
`if(semaphore.tryAcquire())`
try{} finally{semaphore.release()}

<h2> ThreadFactory</h2>

- threadpool that creates thread
- ThreadFactory factory = runnable -> new Thread(
- Thread thread = Factory.newThread(()-> factory.newThread(new Task(),t.start);

<h2> BlockingQueue</h2>

BlockingQueue<String> queue = new LinkedBlockingQueue();
queue.put("item");
String item = queue.take();

<h2> UnboundedQueue</h2>
- consumer need to consume as producer produce or else out of memory

<h2> BoundedQueue</h2>

BLockingQueue<String> blockingQueue = new LinkedBlockingDeque<>()l

Methods:

| Adding Elements              |                                                                  |
|------------------------------|------------------------------------------------------------------|
| Behaviour when queue is full |                                                                  |
| add(E e)                     | throws IllegalStateException                                     |
|put| Blocks until space is available                                  |
|offer| return false Immediately                                         |
|offer(E e, timeout,timeunit)| wait for time after specified timeout returns full if still full |

|Removing Elements||
|--|--|
|Behaviour when queue is empty||
|remove|Throws NoSuchElementException|
|take|Blocks until an element is available|
|poll|returns null immediately|
|poll(long timeout,Timeunit timeunit)|Wait till timeout returns null if still empty|

| Inspecting Elements |                               |
|---------------------|-------------------------------|
| element             | Throws NosuchelementException |
| peek                | returns null immediately      |

|  Utility Method |                        |
|-----------------|------------------------|
| size            | current size of element |
|remainingCapacity|remaining space before full|
|contains|Checks if element exists|
|clear|removes all elements|
|drainTo|Removes all elements into another collection|

Benefits:
- Bounded: fixed capacity
- producer-consumer pattern
- non-blocking: offer and poll return immediately
- Timed method: waiting for a period

<h2> Multithreaded Producer COnsumer</h2>

- 4 producer threads using put method to block
- put poison pill to indicate no message left
- finish execution
  - ```
    run(){
    try{
       generateNumbers();
        } catch(InterruptedException){
    }
    }
  
    generateNumbers() throw InterruptedException
    for( int i = 0; i < length;i++){
      nbumberQueue.put(ThreadLocalRandom.current()/nextInt(100))
    
    }
    int poisonPill = Integer.MaxValue()
    for() {
    numberQueue.put(poisonPill)}
  
    run() {
      try{
      while(true){
      queue.take()l
      if(number.equals(poisonpill)){
      return;
      }catch(InterruptedException e){
      Thread.currentThread(Interrupt();)
        }
      }
    }
    ```
    Check if each message is poisonpill
  - finish execution if poisonpill
  
  <h3> DelayQueue</h3>
  
  - infinite size blocking queue
  - pulled only when defined delay completed
  - head most delayed and polled last
  - `queue.put(new DelayedElement())`
  - `element = queue.take()`
  - ```
    public class DelayObject implements Delayed {
      DelayedObject(String data,long DelayInMilliseconds)
      this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }
    ``` 
    
```
@Override
public long getDelyay(TimeUnit timeUnit)
  long diff = startTime-System.currentTimeMillis();
```
Delayqueue return 0 or negative can retrieve

```
@Override
public int compareTo(Delayed o) {
return Ints.saturatedCast(
  this.startTime - ((DelayObject) o ) startTime);
)}
```
```
ExecutorService executor = Executors.newFixedThreadPool(2);
BlockingQueue<DelatObject> queue = new DelayQueue<>();
DelayQueue Producer producer = new DelayQueueProducer (queue, number of elements to produce,delay of message)

executor.submit(producer)
executor.submit(consumer)
executor.awaitTermination(3,TimeUnit.seconds);
executor.shutDown();
```
COnsumer may not be able to consume in given time
if expiration is negative consume immediately 

