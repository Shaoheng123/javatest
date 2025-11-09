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

<h2>Usage</h2>
<h3> Design Patterns</h3>
1. Singleton Pattern
- Enum implements the serializable interface
- Only defined constants instantiated, guaranteed single instance
- Immune to Reflection creating another class

2. Strategy Pattern
- use Enum to represent different strategies
- Lambdas with enum to represent different strategies
  - `PizzaStatus.contains(s.getStatus().collect(Collectors.toList()))` 

<h2> Jackson</h2>
Serialize object to json format
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonProperty("timeToDelivery")

<h2>Sealing (Java 17)</h2>
Define permitted subtypes
<h2>Constraints</h2>
1. All permitted subclasses in the same module as superclass.  
2. Every permitted subclass must explicitly extend sealed class
3. All subclass must define a modifier

<h2>Usage</h2>
Permitted subclass
```
if (vehicle instanceof Car) {
    return ((Car) vehicle).getNumberOfSeats();
```

Pattern Matching
```
if(vehicle instanceof Car car) {
    return car.getNumberOfSeats
} else {
    throw new RuntimeException
}
```
throw Runtime Exception if not covered
<h2>Records</h2>

final
<h2>Reflection</h2>
`isSealed()`
`getPermittedSubclasses`

<h2>Transient</h2>
Do not serialize
value is 0 or null

<h2>Usage</h2>
Derived Fields(subclass)
Fields that does not represent object state
Non-serializable reference
storing sensitive information

<h2>Final</h2>
value not lost because it's a compile-time constant
reinitialize during class loading

<h2> new String();</h2>

`private final transient String bookCategoryNewOperator = new String("Fiction with new Operator");`

Not serialized JVM does not reinitialize, null input

<h2> Instance Of</h2>

used before casting unknown object avoid ClassCastException
`object.instanceOf(type)`
Instance of Class, Subclass or Interface

Instance.of(null) is null
Don't need null check 

<h3>Generic</h3>

- Primitive
- Non-Generic classes and interfaces
- Generic types
- Raw types
- Arrays of other reifiable types

`if (collection instanceof List<?>)`

ClassCastException will be raised as a Circle is not a Ring

```
Stream<Round> roundStream = Stream.of(new Ring(), new Ring(), new Circle());

assertThrows(ClassCastException.class, () -> roundStream.map(it -> (Ring) it).collect(Collectors.toList()));
```
Filter out those that are not ring before mapping

```
Stream<Round> roundStream = Stream.of(new Ring(), new Ring(), new Circle());


List<Ring> ringList = roundStream.filter(it -> it instanceof Ring).map(it -> (Ring) it).collect(Collectors.toList());
```
<h2>TypeCasting</h2>
<h3> Primitive</h3>
Conversion of primitive means irreversible changes in value
<h3>Reference</h3>
Upcasting narrows lists of methods and properties available
Downcasting extend it

<h3> Upcasting</h3>
casting from subclass to superclass
Implicitly done automatically
restrict number of methods available to Cat instance
cannot use subclass methods

<h3> Upcasting to an interface</h3>
- Refer to object if object is same type as variable or subtype
- Upcasting happens implicity
- Polymorphic and can be treated as objects of supertype due to upcasting.

To use subclass method have to downcast to the method

If they are not a inheritance tree relationship, ClassCastException.

```
if (Cat.class.isInstance(animal)) {

    Cat cat = Cat.class.cast(animal); 
    cat.meow();
}

```
feed() method checks animal and returns instance of T

```
public AnimalFeederGeneric(Class<T> type) { this.type = type; }

Class instance passed to generic as constructor

 

Animals.forEach(animal -> {

if (type.isInstance(animal)) {

T objAsType = type.cast(animal); list.add(objAsType);

}
```












