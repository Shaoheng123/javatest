<h1> Future</h1>

Future result of async computation
- Best big data, remote method calls (Download)
- long running because execute other processes

<h2> FutureTask</h2>

- Callable interface representing task that returns a result: lambda expression
- pass into executor that starts task in new thread that returns Future<Object>

Submitting callable to Executor service
- submit method initiates execution of the task and returns Future object
- Future object represents pending result of Callable computation
- Callable interface similar to Runnable return a result and throw checked exceptions

```
  import java.util.concurrent.Callable;

    class MyCallable implements Callable<String> {
        private String message;

        public MyCallable(String message) {
            this.message = message;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(1000); // Simulate a long-running task
            return "Task completed: " + message;
        }
    }
```

<h2> Submit to Executor Service</h2>

```
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    import java.util.concurrent.Future;

    public class ExecutorServiceExample {
        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            MyCallable callableTask = new MyCallable("Hello from Callable!");
            Future<String> future = executor.submit(callableTask);
            // ... (main thread can do other work)
        }
    }
```

<h2> Returning a Future</h2>

```
    // ... (from previous example)
    try {
        String result = future.get(); // Blocks until the task completes
        System.out.println(result);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        executor.shutdown();
    }
```

- submit starts Callable task and provides a Future as handle to manage and retrieve eventual result
- FutureTask is implementation of Future and Runnable that wraps a Callable and manages execution and result.
- Executor uses FutureTask to manage lifecycle of submitted Callable

<h2>Consuming Futures</h2>
- isDone()
- get()
- ```
  Future<Integer> future = new Method().calculate;
  while(!future.isDone()) {}
  Integer result = future.get()
  Integer result = future.get(500, TimeUnitMILLIS)
  future.cancel(boolean)
  can avoid cancellationException

  ```

<h2> Multi-threading Thread Pools</h2>
Executors.newFixedThreadPool(int number) - sets how many threadpool

<h2> ForkJoinTask</h2>

abstract class which implements Future
- small number of actual threads run large number of task
- spawn new subtasks to complete main task
- RecursiveTask returns value RecursiveAction
- used mainly for recursive task such as file-system navigation
- `fork()`
  - non blocking initialization execution of subtask
- `join()`
  return result from calculation
- ForkJoinPool
    - handle execution and thread management
    - `forkJoinPool.execute(calculator)`
    - spawn multiple tasks in recursive algorithm
    - does not create new thread for each task but work-stealing algorithm

<h2>CompletableFuture(Java 8)</h2>

- implements both Future interface and COmpletionStage
- compose
- combine
- execute asynchronous computing and handle more

<h2> Basic</h2>

- hand future result to consumers, complete in future using complete method
- get methodm to block current thread till result provided
- CompleteableFuture spins computation in anothger thread and returns Future
- provide result to the complete method

```
CompleteableFuture cf = new CompletableFuture
Executors.newCachedThreadPool().submit(()-> completeableFuture.complete(""));
```
get()
- block for result
- ExecutionException
- InterruptedException

```
CompletableFuture.completedFuture(); 
```
result of computation is known
completableFUture.get()

<h3> CompletableFuture with Encapsulated Computation logic</h3>

- Runnable and Supplier
- `CompletableFuture.runAsync()`
- `CompletableFuture.supplyAsync`

<h3> Processing result of Computation</h3>
<h4>Function</h4>

- `CompletableFuture.supplyAsync(()->{})`
- `CompletableFuture.thenApply(s->{})`
- Accept, Function instance, process
  - returns Future returned by a function
<h4> Consumer</h4>

- `CompleteableFuture.thenAccept(s->{})` - dont need result
- `CompleteableFuture.supplyAsync()`
  - receive consumer and pass result() 
<h4> Runnable</h4>
  - completableFuture.thenRun(()->{});
    - DOn't need value of computation nor return value

<h3> Combining Future</h3>

- Monadic
  - Chaining of CompletableFuture and combining, then compose-chain 2 Futures
- Design PAttern
  - takes a function that returns COmpletableFuture
  - Argument is result of previous computation
  - `CompletableFuture = CompletableFuture.supplyAsync(). thenCompose(s->CompletableFuture.supplyAsync()`
    - receuve function and apply to computation result
  - thenCombined() - receive function that returns another object of samne type
  - Accepts Future and FUnction with 2 arguments to process
  - thenAcceptBoth() - do something with 2 Future's result, dont need any parameter downchain
  - CompletableFuture.supplyAsync().thenAcceptBoth(CompleteableFuture.supplyAsync(()->{}))
<h3> Difference between thenApply and thenCOmpose (Chaining)</h3>
    - |thenApply|thenCompose|
      |--|--|
      | work with result of previous call|use previous stage as argument|
      |return type combined of all calls|flatten and return FUture with result directly|
    - return new COmpletionStage

<h3> Running multiple Futures in parallel</h3>

- wait for completion of all the Futures
- `CompleteableFuture.allOf(future1,future2,future3);`
- `Stream.of(future1,future2,future3).map(CompletableFuture::join).collect(Collectors.joining(" "))`
- `throws unchecked exceptiuon if future not completed `
- `stream.map()`
<h3>Handling</h3>

- ```CompletableFuture.supplyAsync(()->{if(name == null) throw RunTimeError}).handle((s,t)-> s!=null?s:"Hello)```
- handle to provide when error
  - ```
    completeableFuture.completeExceptionally(new RunTime)
    completableFuture.get=> Execution Exception
    ```
  <h3> Async Methods</h3>
- Async postfix: excution step in another thread
<h3>Non Async</h3>
- run using calling thread
- Async without Executor
- runs step using common fork/join of Executor accessed with ForkJoinPool.commonPool() parallelism >1
- Under hood ApplyAsync wrap in Fork/join to effect when parallelism >1
<h3> CompletableFuture(JDK 9)</h3>

- defaultExecutor -returns default for async method
- newInCompleteFUture - useful in subclassing because used internally for complete control subtype element
- copy
  - defensive copying, prevent client complete
  - new CompleteableFuture completes normally if original complete normally else completionException
  - minimalCOmpletion Stage 
    - expose completableFuture from modify but arrange goto
    - `CompleteAsync` - complete COmpletableFUture using value by Supplier or `TimeOut(1,seconds)` complete or with timeout exception
    - delayedExecutor() returns Executor submit after given delay 
    - completedStage
    - failedStage - return Exception
    - failedFuture -specify already completed exceptionally 
    - instance 
      - testing failure condition in async workflow

