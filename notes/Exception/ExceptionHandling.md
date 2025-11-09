<h1> Exception Handling</h1>

Exceptions:
- Checked Exception
- Unchecked Exception
- Errors

Checked Exception:
Must be handled ot Declared
Examples:
-IOException
- Servlet Exception

Unchecked Exception
Do not need explicit Handling
Examples:
- try catch
- try with
- finally

Best practice:
- Logging
- avoid swallowing exception
- Custom Exception

Anti Patterns:
- return or throw in finally block
- swallow exceptions
- throw as a goto

Reasons:

-corrupt filesystem
- break network
- Prevent JVM from running out of memory

Handling Exceptions
- throws: method that calls need to handle
- try-catch: handle or rethrow exception
- try-with(java 7) implements the auto-closeable interface automatically manager and close files, streams and database connections
- parseInt: DOnt need to handle exception
- finally: clean up regardless
    - close also need to catch exception
- Union catch
    -Catch multiple exception
- Throwing Exception
    - shows that need to handle this exception by caller
- Wrapping Exception


Try-with

```
try(Scanner scanner ) {
    return ;
} catch(){
}
```

Union catch
- `try{} catch(IOException|NotFoundException)`

Throwing Exception
    Class class throws Exception
        throw new ExceptionType(message);

Custom Exception
```
public class Exception extends Exception {
    public MyException (String message) {
        super(message);
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

Common Exceptions
|--|--|--|
|Checked|Unchecked|Errors|
|IOException|ArrayIndexOutOfBounds|StackOverFlow|
||ClassCastException|NoClassDefFound|
||IllegalArgumentException|OutOFMemory|
||NullPointerException||
||NumberFormatException||

