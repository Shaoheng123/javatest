<h1> Keywords</h1>

<h2> Volatile</h2>
- memory visibility and order in concurrent
- prevents caching variables 
- updates to variable visible to other threads

<h2> Useful </h2>

multi threaded environments where memory consistency error occur due to caching and instruction reordering

<h2>Shared Multiprocessor Architecture </h2>
- Processor Out of Order Execution
- Branch Prediction
- Speculative Execution and Caching
- Cores fill cache with data and instructions
- improve overall performance but cache coherence challenge
- Thread update cached value

<h2> Cache Coherence Challenges</h2>

- TaskRunner class maintains 2 variables
- prints number variable when thread is ready
- Lack of proper memory visibility and reordering

<h2> Memory Visibility</h2>

- main and reader thread
- OS schedule threads on 2 CPU cores
- main thread has copy of ready and number variables
- Processors queue write requests that won't apply issued
- queue writes in special write buffer
- apply to main memory at once
- no guarantee when read thread may see value

<h2> Reordering</h2>

- reader thread may not see writes other than actual program order

<h2> Volatile Memory Order</h2>

- updates to variable propagate predictably
- add volatile keyword
- communicate with run-time and processor to avoid reordering in structure
- processor should immediately flush updates to variable

<h2> volatile and Thread Synchronization</h2>

- Mutual Exclusion
  - 1 thread executes critical section
- Visibility 
  - changes made by 1 thread visible to others for data consistency
  - Help ensure visibility aspect of data change without providing mutual exclusion

Volatile
- shared variable include volatile modifier guarantees
- all threads see consistent value for shared variable
- Update to volatile field updates shared value of field
- Different thread cannot get inconsistent value of shared variables after value updated
<h2> Happens- Before Ordering</h2>
- memory visibility beyond volatile variables
- values visible to A before writing volatile variables visible to B after reading volatile variable

<h2> Main Thread</h2>
- Any write to volatile field happens before every subsequent read of same field

<h2> Piggybacking</h2>

Piggybacking visibility properties of another volatile variable
- `private volatile static boolean ready;`
- `private static int number;`
- number exhibits volatile behaviour because of 
- so can declare few variable as variables in class
- Changes to nonVolatile data by writer thread made visible to ready thread when ready flag is set and observed


