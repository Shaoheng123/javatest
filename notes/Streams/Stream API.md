<h1>Stream</h1>

<h2> Stream Creation</h2>

- `Arrays.stream(arr)`
- `Stream.of("a","b")`
- `list.stream()`

<h2> Multi-Threading</h2>
<h3> parallelStream</h3>

- `list.parallelStream().forEach(element->doWork(element));`
<h2> Operators</h2>
- intermediate operators - chaining
  - filter
  - map
  - distinct
- terminal operator - no other operators can be chained
    - count
    - collect
- `list.streams.distinct().count()`
  
<h3>Iterating</h3>
- `list.stream().anyMatch(element ->element.contains())`
<h3> Filtering</h3> satisfy predicate
`list.stream().filter(element->element.contains())`
<h3>Mapping</h3>
- `urls.string().map(url->Paths.get(uri));`
- Converts Each element by applying lambda expression
<h3>FlatMap</h3>
- Each element contains sequence of elements and stream of inner elements
- Every element from inner class extracted and added to the stream
-`Stream<String> stream = details.stream().flatMap(detail->detail.getParts().stream())`
- stream of details will be lost

<h3> Matching</h3>
predicate returns true if conditions are met

- anyMatch()
- allMatch()
- noneMatch()

<h3> Reduction</h3>

- reduce()- takes in start and accumulator
- `integers.stream().reduce(23,(a,b)->a+b)`
- start at 23 accumulator function

<h3> Collections</h3>

- `List<String> list = list.stream().map(e->e.toUppercase().collect(Collectors.toList());`
- Reduce stream<String> to List<String>

<h2>Java Collectors</h2>

<h3> Stream.collect();</h3>

- mutable fold repackage element and apply logic to data elements in a stream instance

<h3> Collectors</h3>

Collectors.toCollection()
`List<String> result = givenList.stream().collect(toCollection(LinkedList::Next))`

Collectors.toList()
- collect all stream elements into list
- `givenList.stream().collect(toList)`

Collectors.toUnmodifiableList()
- `givenList.stream().collect(toUnmodifiableList)`
Collectors.toSet()
- `givenList.stream.collect(toSet())`
Collectors.toMap()
- KeyMapper()
- ValueMapper()
- `Map<Character,String> map = names.stream().collect(Collectors.toMap(name ->name.charAt(0),Function.identity()`
- Function.identity maps each element in the original back to itself
Handle Key Collision
- givenList.stream().collect(toMap(keyMapper,valueMapper),(existing,replacement)->existing);
- Collectors.toUnmodifiableMap()
- `givenList.stream().collect(toMap(keyMapper,valueMapper),)`
- Collectors.collectingAndThen()
- perform an action on result after collecting(convert to immutable)
- `list.stream().collect(collectingAndThen(toList,Immutable::copyOf))`

Collectors.joining

- `givenList.stream().collect(joining())`;
- `list.stream().collect(joining("",prefix,postfix))`
Collectors.counting()
- list.stream().collect(counting());

Collectors.summarizingDouble

- `DoubleSummaryStatistics = givenList.stream().collect(summarizingDouble(String::length));`
Methods
- result.getAverage()
- result.getCount()
- result.getMax()
- result.getMin()
- result.getSum()

AveragingDouble
- `givenList.stream().collect(averagingDouble(String::length))`
SummingDouble
- `givenList.stream().collect(summingDouble(String::length))`

Collectors.maxBy

- `maxBy(Comparator.naturalOrder());`

Collectors.groupingBy
- `list.stream().collect(String::length,toSet())`

Collectors.partitioningBy
- groupingBy that accepts predicate
- collect stream element that stores boolean as keys
- collection of elements matching predicate

- `givenList.stream().collect.partitioningBy(s->s.length()>2);`
- `result ={false = [], true=[]}`

Collectors.teeing()
 - Receive results and combine them
```
Optional<Integer> min = numbers.stream().collect(minBy(Integer::compareTo()));
```
`numbers.stream().collect(teeing(minBy(Integer::compareTo().maxBy(Integer::compareTo),(min,max))))`

Custom Collectors

public interface Collector<T,A,R>

- T:types of objects for collection
- A: mutable accumulator object
- R: final Result

```
implements Collector<T,ImmutableSet.Builder<T>, ImmutableSet<T>>
```
Supplier 
```
@Override
public Supplier<Immutable(Set.Builder<T>)> {
  return ImmutableSet::Builder;
}
```

Combiner
merge and accumulator
```
@Override
public Biconsumer<ImmutableSet.Builder<T>,T> accumultator()
return ImmutableSet.Builder::add;
```
Finisher
```
@Override
public BinaryOperator<ImmutableSet.Builder<T>,ImmutableSet<T>>
return ImmutableSet::Build
```

Characteristics
```
@Override
public Set<Characteristics> 
  return sets.immutableEnumSet(Characteristrics.unordered)
```
<h2>Usage</h2>

`givenList.stream().collect(toImmutableSet());`

- - filtering
- - flatMapping with groupingBy(Java 9)
- - filter then filter()
- - filtered then group

Filter then group:
- ```
  numbers.stream().filter(val -> val>3)
    .collect(Collectors.groupBy(i->i, Collectors.counting))
  ```
  grouping By then filter

- ```
  numbers.stream().collect(Collectors.groupingBy(i->i, Collectors.filtering(val -> val >3, Collectors.counting())));
  ```
  flatMapping
Flattens during grouping
- skip intermediate collection for map
- ```
  blogs.stream().collect(Collectors.groupingBy(Blog::getAuthorName,Collectors.flatMapping(blog -> blog.getComments().stream())))
  ```
  
Direct stream of comment into collector's container

Stream.filter
- intermediate operation of stream to filter elements that match given predicate
  - lambda 
    - .filter(c->c.getPoints > 100);
    - .filter(Customers::moreThan100)
      - moreThan100(return this.points > 100)

Handling Exceptions
- wrap in try catch
- Throwing predicate
- ThrowingPredicate unchecked(Customer::hasMethod
- )