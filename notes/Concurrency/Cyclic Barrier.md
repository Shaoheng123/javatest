<h1> Cyclic Barrier</h1>

- reused after waiting threads released
- synchronizer that allows threads to wait to reach common execution point
<h2>Usage</h2>

- Fixed number of threads that wait at a common point before continuing
<h2> Constructor</h2>

```
public CyclicBarrier(int parties)
- number of threads call await
synchronous
tripping the barrier
public CyclicBarrier(int parties, Runnable barrierAction)
```
Implementation
- LAst one that finishes start processing
- partialResults= `Collections.synchronizedList( new ArrayList<>())`
- multiple threads writing

<h2> Aggregator Thread</h2>

```
@run() {
for (List<Integer> threadResult:partialResults) {
    for (Integer partialResult : threadResult) {
    sum += partialResult;
    new CyclicBarrier(NUM_WORKERS, new Aggrgator Thread());
    }
}
}
```

<h2> Cyclic Barrier vs COuntdownLatch</h2>

|             | Countdown Latch                               | Cyclic Barrier                                                                                       |
|-------------|-----------------------------------------------|------------------------------------------------------------------------------------------------------|
|             | wait for other threads to countdown the latch | group of threads waits till all threads arrive                                                       |
|             | same thread can decrease count twice          | second await useless single thread cannot countdown barrier twice, another thread call await to work |
|             | maintain count on tasks                       | wait on count of threads                                                                             |
| Reusability | count never resets                            | count resets to original once it reaches 0                                                           |


