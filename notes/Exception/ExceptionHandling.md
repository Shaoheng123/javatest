<h1> Exception Handling</h1>

-------
<h2>Exceptions:</h2>
- Checked Exception
- Unchecked Exception
- Errors

<h2>Checked Exception:</h2>

Must be handled or Declared
Examples:
- IOException
- Servlet Exception

<h2>Unchecked Exception</h2>

Do not need explicit Handling
Examples:
- try catch
- try with
- finally

<h2>Common Exceptions</h2>

|Checked|Unchecked|Errors|
|---|---|---|
|IOException|ArrayIndexOutOfBounds|StackOverFlow|
||ClassCastException|NoClassDefFound|
||IllegalArgumentException|OutOFMemory|
||NullPointerException||
||NumberFormatException||


<h2>Best practice:</h2>
- Logging
- avoid swallowing exception
- Custom Exception

<h2>Anti Patterns:</h2>

- return or throw in finally block
- swallow exceptions
- throw as a goto

<h2>Reasons:</h2>

- corrupt filesystem
- break network
- Prevent JVM from running out of memory

<h2>Handling Exceptions</h2>
- throws: method that calls need to handle
- try-catch: handle or rethrow exception
- try-with(java 7) implements the auto-closeable interface automatically manager and close files, streams and database connections
  - final as long as not change effectively final 
- parseInt: DOnt need to handle exception
- finally: clean up regardless
    - close also need to catch exception
- Union catch
    -Catch multiple exception
- Throwing Exception
    - shows that need to handle this exception by caller
- Wrapping Exception
- Chained Exceptions
    - identify root causes like division by 0
- Throwable
    - Constructors
      - Throwable(Throwable cause,String desc)
    - Methods
        - getCause() : actual cause
        - initCause(Throwable cause) set cause

<h2>Custom Exception:</h2>
- Business Logic
- Provide for subset of existing  Exceptions
- Checked and Unchecked Exceptions
    - Constructors
    - error message and throwable for root Exception
  
<h2>Examples</h2>

Try-with( Java 9)

```
try(Scanner scanner ) {
    return ;
    } catch(){
}
```

Union catch
- `try{} catch(IOException|NotFoundException)`

Throwing Exception
   ```
    Class class throws Exception
        throw new ExceptionType(message);
   ```
   
Custom Exception
```
public class Exception extends Exception {
    public MyException (String message) {
        super(message);
    }
}
```
<h3>CheckedException</h3>
```
public class CheckedException extends Exception {
    public CheckedException(String message) {
    super(message);
    }
    public CheckedException(String message, Throwable cause){
        super(message,cause);
    }
}

```

<h3>UnCheckedException</h3>

```
public class UncheckedException extends RunTimeException {
    public UncheckedException(String message) {
    }
    public void uncheckedException(String message) {
        super(message,cause);
    }
}
```
Wrapping 

```
try {
}catch(IOException e)
 throw new CustomException
```
Inheritance: subclasses can only throw fewer checked exceptions than super class.
Chained Exceptions
```
ChainedException{
    try {} throw new ArithMeticException().initCause(new IOException)
} catch ArithmeticException{ae.getCause()}
}
```
Caught: ArithmeticException
Cause: IOException

Difference between throw and throws

- throw: explicitly throw exception from method or block
- throws: method declaration to indicate which exception thrown
`throw new ArithmeticException()`

