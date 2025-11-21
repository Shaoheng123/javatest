<h1>Locks</h1>

```
Lock lock = new ReentrantLock();
lock.lock();
try{} finally{
    lock.unlock();
} 
```
<h2>Difference between lock and synchronized block</h2>

|Synchronized block|Lock|
|--|--|
|Synchronized Block is in a method|lock and unlock can be separate|
|any thread can acquire lock once released| longest waiting thread given access|
|cannot be interrupted|cannot get access if thread gets block|
||tryLock() thread acquires lock only if available and not held by other thread|

<h2>Lock API</h2>

- lock() acquire lock if available thread blocked till released
- lock Interruptinly- allow blocked thread to be interrupted and resume execution through InterruptedException
- tryLock(): returns true if succeed
- tryLock(timeout,timeUnit): waits before giving up
- unlock to avoid deadlock

<h2>ReadWriteLock interfaces</h2>
- readLock(): lock for reading multiple threads
- writeLock() - lock for writing

<h2>ReEntrantLock</h2>

-Reentrant Lock: synchronization

```
isLockAcquired= lock.try
if(isLockAcquired){
    try{} finally{lock.unlock();}
}
```
<h2> REEntrantReadWriteLock</h2>

- Read Lock
    - if write not request or accessed, multiple threads read
- Write Lock 
    - only 1 thread acquire write if no threads read/write
```
    ReadWriteLock = new ReentrantReadWriteLock()
    Lock writeLock = lock.writeLock();
    syncHashMap.put(key,value);
    remove(String key){
    try{
    writeLock.lock()
       return syncHashMap.remove(Key);
    } finally{
    writeLock.unlock();
        }
    }
```

```
containsKey( String key) {
    try {
        readLock.lock();
    }
    return syncHashMap.containsKey(key);
    } finally(readLock.unlock();
    }
}
get(String Key) {
    readLock.lock();
    return syncHashMap.get(key);
}finally{readLock.unlock();}
```

<h2>StampLock(Java 8)</h2>
```
private StampedLock lock = new StampedLock();
    put(String key, String value) {
        long stamp = lock.writeLock();
        try {
            map.put(key,value);
            if(!lock.validate(stamp){
                stamp = lock.readLock();
                try{
                    return map.get(key);
                } finally {
                    lock.unlock(stamp);
                }
                return value;
            })
        }
    }
```

<h2> WorkingWith</h2>

Condition - thread wait before critical section
```
Condition stackEmpty = lock.newCondition();
stackFullCOndition = pushToStack(String item) {
    while(stack.size() == capacity) {
    stackFullCondition.await();
    }
    stack.pushitem();
    staclEmptyCondition.signallAll();
    } finally {
    lock.unlock();
    }
}
```

```
popFromStack() {
    try{
    lock.lock();
    } while (stack.size() == 0) {
    stackEmptyCondition.await();
    }
    
    return stack.pop();
} finally {
    StackFullCOndition.signallAll();
    lock.unlock();
}
```
