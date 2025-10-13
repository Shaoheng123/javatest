<h1>this</h1>
<h2>Key Points:</h2>

1. Method hiding to hide superclass
2. Access Instance Keyword
3. Must be First Line of constructor
4. Constructor Chaining
```
public KeywordTest() {
    this("John",27)
}
public KeywordTest(String name, age) {

}

```
Calling Outer class from inner class
```
public class InnerClass() {
    KeywordTest = KeywordTest.this;
    String outerString = KeywordTest.this.name;
}
```
<h1>Super</h1>

1. super must be first line

```
SuperClass child = new SuperClass();
super.print()  -- calls parent method from parent class
```
<h1> Static </h1>

Methods and fields belong to class
<h2> Fields </h2>
1. Only 1 copy of field created and shared among all instances
2. Static fields are stored in heap
3. Usage 
   - static variable
     - independent of other objects
   - counter
     - value shared across all objects
   - access from instance
   
<h2> Methods</h2>

1. Static Method resolve at compile time
2. cannot access instance field and methods without object reference
3. Usage:
    - Encapsulate classes
    - Decouple from outer class 
    - Maintainability

Static Code Block:
Needed to initialize initial values
```
static {
    ranks.add("");
}
```
<h3>Difference between inner class and nested static</h3>
- Inner class: access to all methods of outer class
- Static: access to only static methods of outer class

<h2> Final Keyword </h2>
<h3> Classes</h3>

1. cannot extend classes with final keyword
   - should not override immutable class/methods
   - fields can be changed
   - cannot override method 
   
<h3> Methods</h3>

1. Usage:Prevent overriding of the method
2. Reason: Native code(isAlive)
 - Variables: Cannot be reassigned
 - Reference Variable: can alter object members but cannot reassign
`final List<Object> finalList = new ArrayList<>()`
`finalList.add(obj1)`

<h2> Assigning values to field</h2>
<h3>Static</h3>

1. Declaration
2. static block

<h3>Instance</h3>
1. Declaration
2. Initializer Block
3. Constructor
<h3>Parameter</h3>
Cannot assign

<h1> Records(Java 14)</h1>
<h2>Records</h2>

1. Immutable data classes with type and name of class
2. final by default
3. all fields private final
4. Initialize all fields

<h2>Java Compiler Methods</h2>
- equals(): all fields
- hashCode(): calculate based on all fields
- toString(): all fields 
- record

- Purpose: Reduce boilerplate code
- Generates Methods by Java Compiler
- Can have same constructor as Record

- Need to assign fields yourself 

```
public Person{
   Objects.requireNonNull(name);
}
```
<h2> Static Fields in Record</h2>
Can have static fields

<h1> Enums</h1>

<h2>Benefits:</h2>
- Readability
- Compile-time checking
- White list accepted value
- Encapsulation
- Polymorphism

<h2>Comparing Enum values</h2>
<h3> Run-time</h3>
1. == 
   - No Runtime exception
2. .equals()
- Possible NullPointerException cannot compare to null

<h3> Field</h3>
set via constructor and accessed via getter
`PizzaStatus(int timeToDeliver)`

```
  PizzaStatus(int timeToDelivery) {
        this.timeToDelivery = timeToDelivery;
    }
```
<h2> Constructor</h2>

PizzaStatus(int timeToDelivery)
initializes the field 
Enum constant `ORDERED(5)`calls constructor with its own value

<h2> Method:</h2>
Override method to define custom behaviour

<h2> EnumSet</h2>

Uses bit vector representation for speed and memory efficiency

<h2>Implementation:</h2>

- RegularEnumSet
- JumboSet

<h2> Operation</h2>
subset
add
remove
containsAll
removeAll

Iterate:
Enum.values()
1Z    

