<h1>Object.equals()</h1>

<h2>AutoBoxing</h2>
comparing primitive with wrapper class

Equality:
1. `Integer a = new Integer(1);`
2. `Integer b = new Integer(1);`
`returns false`

Memory addresses are different

Stores Integer in cache and return same Integer instance

<h2>Equals</h2>
compares object memory addresses
Can be overwritten

HashCode is calculated based on number of fields included

<h2>Comparing with </h2>
Cannot Object.equals(null)

Integer a = new Integer(1);
Integer b = a;
if assigned to same object, then value will be true

<h2>Object.equals</h2>
- static
1. `Object.equals(null,null)`
   - true
2. `Object.equals(null, 1)`
    -false

Comparable Interface:
Can only have 1 implementation
class cannot implement other interface
```
public class PersonWithEqualsAndComparable implements Comparable<PersonWithEqualsAndComparable> {

//... @Override public int compareTo(PersonWithEqualsAndComparable o) {
    return this.lastName.compareTo(o.lastName);
    }
}
```
Returns an int after comparing

<h2>Comparator</h2>

<h3>Method</h3>
- `int compare(T o1, T o2)`
- `Comparator<Person> byName = Comparator.comparing(Person::getName);`

<h3>Multiple Comparator</h3>
```
Comparator<Person> byName = Comparator.comparaing(Address::getCountry,Address::getCity,nullsLast).compare(this,o);
```
nulls values go last

<h3>Usage(Comparator):</h3>

- lambda = (p1,p2) -> Integer.compare(p1,get(),p2.get);
- factory = Comparator.comparing(Player::getRanking);

<h3> When to use</h3>

- Comparable : natural ordering and modify class
- Comparator : multiple sorting and cannot modify class

<h3>Generics(Java 5)</h3>

- Add abstraction over types and improve code safety

<h3> Purpose</h3>
- Explicit casting to solve runtime error
- Enforce type at compile time

<h3> Type Parameter </h3>

- different type parameter surrounded by commas
- public <T,G> List<G> method (T[] G, Function<T,G>)

<h3> Bounded Generic</h3>

- Restrict types that method accepts
- Upper 
  - public<T extends Number>
  - method can have return Integer, Double
- Lower
  - public void method(List<? super Number>) 
  - method can be any class super of Number, e.g: Object
  
  <h3> Use cases</h3>
| UpperBound                  | Lowerbound                 |
|-----------------------------|----------------------------|
| Read from generic structure | Write to genetic structure |
| Read from collection        | Write to collection        |
| Accept subtypes of T        | Any superclass of Integer  |
| Algorithms process elements | Broader type to accept     |
|Expose data but prevent modification|passing handler that consumes value|
|Producer|Consumer|

<h3> Multiple Bounds</h3>

`<T extends Number & Comparable>`

<h3> Wildcards</h3>

|Upper|Lower|
|---|---|
|List<?extends Building>|List<?super Building>|
|Any subtype of building|Any supertype of Building|

<h3>Type Erasure</h3>

Remove type parameters at compile time and replace with bounds or objects

<h3>Primitive Data Type</h3>

- does not extend objects
- box as Integer, Boxed type

<h3>Apache Commons methods:</h3>

notEqual:

- ObjectUtils compare: takes 2 comparable arguments and return Integer

- Default: null values considered greater.

- Can add Boolean argument to make it lesser


<h3>Rule:</h3>

Implementation of equals methods:

- An object must equal itself

- X==y, y==x

- X == y, y ==z, x ==z

- Value of .equals() change only if a property in .equals method change

<h3>Violation:</h3>

Inheriting method when .equals is overwritten

<h3>Solution:</h3>

- Composition: making Money a property of Voucher instead of a Class too.

- hashCode properties:

- value of hashCode change if property in.equals() change

- objects that are equal must return same hashcode

- unequal objects can have the same hashcode

- hashcode must be overwritten when overwriting equals

- When to overwrite .equals and hashcode:

- Objects having intrinsic identity

- No: Object having value property
```
<h2>Rule of .equals()</h2>
<h3>Implementation</h3>
1. Object must equals itself.
2. Value of .equals change only if a property in .equals() change

<h2>Violation</h2>
Inheriting method when .equals() overwritten
<h2>Solution:</h2>
<h3>Composition</h3>
Instead of inheritance, make Voucher class have a money property
```
```
  Voucher(int amount, String currencyCode, String store) {
        this.value = new Money(amount, currencyCode);
    }
```
<h2>HashCode Properties</h2>

1. value of hashcode change if property in .equals change
2. object that are equal must return same hashcode
3. unequal object can have the same hashcode
4. hashcode must be overwritten when overwriting equals

<h2>Don't override:</h2> 
Object class that other classes use

<h2>Override</h2>
Classes that does not affect other classes.


