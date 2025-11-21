<h1> Phaser</h1>

- Reusable Barrier on dynamic number of threads
- need to wait before executing
- multiple phases of execution
<h2> Usage</h2>
- Threads need to wait for phaser
- multiple phase of execution/ reuse Phaser instance
- different number of threads waiting to advance
- register with phaser
- increase registered parties
- cant check whether current thread registered

<h2> Phaser API</h2>


- subclass implementation
- arriveAndAwaitAdvance
    - blocking method
    - arrived parties equal to number of registered parties
    - execution continues
- phase number
- getPhase
- arriveAndDegister(): current thread no longer accounted

```
class LongRunningAction implements Runnable {

run(){
ph.arriveAndAwaitAdvance();
randomWait();
ph.arriveAndDeregister
}}

randomWait(){
    try {
        Thread.sleep()
    }
}
```
Increment number of threads using Phaser

- arriveAndAwaitAdvance: wait for number of arrived parties same as registered parties then continue execution
- arriveandDeregister();

<h2>When to use</h2>

- Multiple phases and need to synchronize before begining the next thread
- number of threads participating can register or deregister for flexibility, unlike cyclic barrier
- Reusable Synchronization
    - Reused across multiple phases (CountDown latch one-shot barrier)
    - Master thread synchronizing multiple groups of threads, each synchronized by a Phaser
