<h1>CallBack</h1>
function passed as a parameter to another function and executed when the function completes

- Solve: asynchronous code
- declare an interface and take implementation as a parameter
```
public interface EventListener {

    String onTrigger();
}

```
- Implementation as parameter

```
public class SynchronousEventListenerImpl implements EventListener {

    @Override
    public String onTrigger(){
        return "Synchronously running callback function";
    }
}
```
<h2> Async Callback Function</h2>

Asynchronous:
- operations that run in parallel
- non-blocking

<h2> Consumers</h2>
Functional Interface accept argument and perform operation but don't return result
Run operations of inner method from parent method.

- passing a function inside getAge() and IncreaseAge Method that perform operation after each getAge and increaseAge finish their task



