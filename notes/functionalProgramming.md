<h1>Higher Order functions</h1>

Capable of receive functions as arguments and returning function as a result
Java treats lambda expressions as objects

<h2> Immutability</h2>

Entity cannot be modified after isntantiation
Fields must be immutable
Nested and collections of immutable must be immutable
One or more constructor
Only get methods

Immutables and Lombok frameworks
Referential transparency: immutable, no side effect

Functional Composition:
function takes function as argument
Function<Double, Double> = sqrt.compose(log);
Compose: combine existing function and executes parameter function then the original.
function passed in argument

<h2> Monads </h2>
Structure programs generically

Wrap value, transform and get value
`Optional.of(2).flatMap(s->Optional.of(f+s)))`

<h2>Currying</h2>

Transform function with multiple arguments into series of functions
```
Function<Double, Function<Double,Double>> weight = gravity -> mass -> mass*gravity;
```
Split function into multiple function, each taking a single argument
until all arguments are supplied
- add.apply(5)
- add5.apply(10) provides the second argument

Scope must be final

<h2>Recursion:</h2>
Eliminate side effects
<h3> Head Recursion</h3>
Calculate results at each step at the head of the calculation

<h3> Tail Recursion</h3>

- recursive call is the last operation performed
- No additional computation performed after recursive call.
- Certain optimizations such as reusing current stack frame to reduce memory usage and prevent stack overflow errors

Tail-call elimination

Types in java are mutable/
Default evaluation is eager
lazy evaluation more efficient in functional programming

lazy evalation using operator short circuiting and functional interfaces
- Type-erasure
- Generics Type-erasure
- missing support for tail-call optimization






