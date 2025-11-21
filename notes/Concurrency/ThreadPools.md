<h2> threadLocal and Thread Pools</h2>

Application borrows thread from pool
- stores thread-confined into current thread's ThreadLocal
- return borrow thread to pool
- Borrow same thread to process other request
- may use some ThreadLocalData if cleanup not done
- Solution:
  - Remove ThreadLocal after use, could be error Prone
  - ```
    beforeExecute()
    afterExecute()-> call remove on each ThreadLocal
        won't cause any issue
        afterExecute(Runnable r, Throwable T)  
  ```

<h2> ThreadLocal</h2>
store data accessible only by specific thread
ThreadLocal threadLocalValue
using value-get or set

```
ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{})
threadLocal.remove();
```

<h2> Store user Data in Map</h2>

- ```
  SharedMapWithUserContext implements Runnable {
    String username = UserRepository.getUserNameForUserId(userId);
    userContextPerUserId.put(userId, new COntext(userName));
  }
  ```

- Store Userdata in ThreadLocal
- Each thread has its own Context in ThreadLocal
- Every object associated with specific thread
- run() fetch suer COntext ands store in ThreadLocal Variable
- ```
  @Pverrode
  public void run() {
  USerContest.set(newContext(userName);)}
  ```
