<h1> Collections</h1>

<h2>ArrayList</h2>

- Random Access O(1)
- Add Element O(1)
- Insert/Delete O(n)
- Searching O(n)

<h2>ArrayList <> Generic class</h2>
Specify initial length to avoid unnecessary resizing
List<String> list = new ArrayList<>(collection);

<h3> Diamond Operator</h3>

Infer type parameter from context
Explicit type declaration help avoid raw type, Runtime Error
Works with complex generic types and type safety by inferring based on context

<h3> Complex Generic</h3>

`Map<String, List<Map<String,Map<String,Integer>>>>`

<h3>Type Inference Car</h3>

Car<Diesel> = new Car();

<h3> Interface</h3>

public class <T extends Engine> implements Vehicle<t>

<h3> Initializing</h3>

- `new ArrayList<>(List.of(4L,5L,6L,7L,8L,9L));`

<h3> Adding</h3>

- `list.add("A")`
- `list.add(index, "B")`
- `list.addAll(collection)`
- `Longstream.range(4,10).boxed().collet(collectingAndThen(toCollection(ArrayList::new), ys ->list.addAll(0,ys))`

<h3>Iterating</h3>

- `Iterator<String> iteratorString = list.iterator();`
- ` ListIterator<String> listIteratorString = list.listIterator();`
Iterator through a list in reverseOrder
```
while(it.hasPrevious()) {
    result.add(it.previous);
}
```

<h3> Searching</h3>

- `list.indexOf()`
- `list.lastIndexOf()`
- `list.stream().filter(name->name.startsWith("A").collect(Collectors.toList())`

<h3> Remove</h3>

- `list.remove()`
- `it.remove()`

<h3> Sequenced Collections(Java 21)</h3>

-`list.addFirst();`
- `list.addLast();`
- `list.getFirst()`
- `list.getLast()`
- `list.removeFirst()`
- `list.removeLast()`

<h2>LinkedList</h2>

<h3>Initialize</h3>

- Collections.synchronizedList(new LinkedList);
- Double-linked list implementation of list and Deque
- permits all, even null

<h3>Feature</h3>

- Traverse list from front or end depending
- Maintain Insertion Order
- Not synchronized
- Fail-fast iterator(ConcurrentModificationException)
- cannot remove while iterating
- Higher memory usage

<h3> Comparison with ArrayList </h3>

- Random access O(1) LinkedList O(n)
- LinkedList faster insertion/deletion
- Arraylist use less memory


<h3> Usage</h3>

- LinkedList when insert/add/remove
- no need to resize array or update index

<h2> Initialization </h2>

- `new LinkedList<>()`
- `new LinkedList<>(collection)`

<h2> Usage </h2>

- Add : `add()`, `addFirst()`,`addLast()`
- Remove : `remove()`, `removeFirst();`,`removeLast()`,`removeFirstOccurence(object)`,`removeLastOccurence()`
- Queue: `poll()`, `pop()`,`push()`
- Insert: `add(index,element)`
- Convert to list:`Arrays.asList();` `Collections.addAll(linkedList,array)`,`new LinkedList<>(list)`

LinkedList : Good for frequent insertion/Deletion

<h2>Generic Operator(Java 7)</h2>

- infer type parameter from context
- Explicit type declaration help avoid raw time and runtime error
- Works with complex generic types and type safety
- by inferring based on context
- Complex Genetic: Map<String,List<>Map<>String,Map<String,Integer>>

Type Inference

`Car<Diesel = new Car<>();`

Interface
- `public class Diesel implements Engine{}`
- `public class Car<T extends Engine> implements Vehicle<T>`
- `infer type and determine constructor`
