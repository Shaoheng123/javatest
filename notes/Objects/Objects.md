<h1>Passing Objects</h1>
Everything is passed by value
However, the value for primitive and objects are different
<h3> Primitive</h3>

- Pass by value
- Any changes to one variable does not modify others
- Parameters passed in methods are clones of original parameters

<h3> Objects</h3>

- Pass by Reference
- Callee and Caller operate on same object
- Any changes in variables will lead to change to original variables

<h2> Parameter Passing</h2>

<h3>Primitive</h3>
actual values copied inside stack

<h3>Object</h3>
Object stored inside the heap
- Reference Variable stored inside the stack
- Reference variable in stack memory pointing to same location in heap copied and pass to the method
- Allocation of new object to reference variable won't be reflected in original object.

<h2>Immutablility of Objects</h2>
Immutability means objects cannot be changed.

<h3>Final keyword</h3>
- must be initialized or through constructor
- means reference variable cannot be reassigned but can still be changed.

<h3>Making an Immutable Object</h3>
- Declare variables with final
- Only have getters and no setters
- Perform defensive copy for mutable objects
`this.dateOfBirth = new Data(dateOfBirth.getTime())`


<h3>Use:</h3>
- Thread Safety
- No Side Effects





