<h1> Delay Code Execution</h1>

- Thread based
- `Thread.sleep`
- catch InterruptedException
- Thread.currentThread().interrupt()
- Thread.currentThread().interrupt()
- TimeUnit.sleep()
- TimeUnit.SECONDS.sleep(seconds)
catych InterruptedException
- Not precise especially for loop

<h2> ExecutorService-based</h2>

```
ScheduledExecutorServiice es = Executors.newSIngleThreadScheduledExecution
executorService.schedule(Class:: task method, delay, TimeUnit.SECONDS)
    .scheduleAtFixedRate(repeatedly call method)
```
<h2> Stop thread after certain time</h2>

- ```
  while(System.currentTimeMillis()< end) {
  
  }
  ```

- Low Accuracy
- Certain threads may block it

<h2> Interrupt Mechanism</h2>

- Separate thread for long-running opertaions
- main thread ends interrupt signal to worker thread on timeout
- if worker finishes before timeout no impact to worker thread
- if(Thread.interrupted())
- check interrupt flag because not all operations are interruptible

<h2> Using a Timer</h2>

- Timer task to interrupt worker thread
- `@Interrupt`
- run()
- ```
  if(thread != null && thread.iusAlive()) {
  thread.interrupt}
  ```
  - take a worker thread during invocation
  - ```
        public TimeOutTask (Thread thread, Timer timer) {
        this.thread = thread;
        this.timer = timer;
        timer.schedule(timeoutTask,3000)
    }     
    ```

<h2> Future get</h2>

```
Future future = executor.submit(
  try{
    future.get(7, TimeUnit.SEDCONDS);
  } catch(TimeOutException e) {
    future.cancel(true)
  }
  finally(executor.shutDownNow)
)
```

- uses a pool to manage thread while Timer uses single thread
<h2> ScheduledExecutorService</h2>
- ```
  Future = executor.submit()
  Runnable = ()->future.cancel(true)
  executor.schedule(Runnable,3000, TimeUnit.MILLISECONDS)
  ```
  Best Method because it does not block main thread

<h2> Guarantee</h2>

- No guarantee that execution stopped because not all blocking method interruptible
- After flag is set, only when interruptible methods
- read/write method only interruptible if invoked on streams
- created with Interruptible Channel
- check interupt flag after every read
- Object.wait
  - interruptible
  - thread blocked in wait method and throw InterruptedException after interrupt flag is set
- blocking method throws InterruptedException
<h2> Design for Interruption</h2>
- perform() throws InterruptedException
  - ```
    while(rnd.nextInt(MAX)!= target) {
      if(Thread.interruped()) {
        throw new InterruptedException
      }
    }
    ```
    
  -find target random integer while asking flag on each iteration
  - ```
    run() {
      forEach(){
      try{
        step.perform();
      } catch(InterruptedException){
    
      }
    }
    }
    ```
    
- handles InterruptedException for stopping task
- Task can be interrupted at any steo
- No Guarantee

<h2> Capture Thread dump</h2>

- snapshot of state of all threads of Java process
- showing content of each thread's stack
- Display thread's activity

<h2> JDK Utility</h2>

- JDK bin
- using command line

<h2> jstack</h2>

- pid and display thread dump in console
- command:
  - jstack[-f][-l][-m][pid]>
    - -f: force thread dump if process dump
    - -l: look ffor ownable synchronizes in heap and locks
    - -m: native stack frames and Java stack frame
    - stack 17264 > /tmp/threaddump.txt
    - jps command to get pid of Java process

<h2> Java Mission Control</h2>

- GUI tool collect and analyze data from Java application
- connect to remote Java process
  - jvisualvm
    - lightweight and open source profiling tool with GUI and console
  -jcmd 
    - recommend
      - jstack
      - jmap(heapdump)
      - system and cmd
      - jconsole
        - thread stack trace
      - summary
        - kill-3: Unix-
          - kill-3 17284 -XX
            - +UnlockDiagnostic VMOptions -XX
            - +LogVMOutput -XX: LogFile =~jvm.log

<h2> ThreadMXBean</h2>

```
private static String threadDump(boolean Monitors.boolean lockedSynchronizers) {
String Buffer
ThreadMXBean = ManagementFactory.getThreadMXBean();
for(ThreadInfo: threadMXBean.dumpAllthreads(monitor,lockedSynchronizers),threadDump.append(threadinfo.toString()))
}
```