<h1> Optional(Java 8</h1>

Use: returns empty instead of null
<h2>Create Optional object</h2>
1. `Optional.empty();`
2. `Optional<String> opt = Optional.of(name);`
3. `Optional.ofNullable(name)`
4. `OPtional.isEmpty()`
5. `Optional.isPresent()`

<h2>Setting a Default Value</h2>
1. Optional.ofNullable(name).orElse();
2. Optional.ofNullable().orElseGet(this::getDefault);
    - recommended for web service call or computationally costly querying database
    -Provides default value using Supplier if Optional is empty(lazy default)
<h3>Handle Empty Exception</h2>
`String name = Optional.ofNullable().orElseThrow()`
<h2> Retrieve Wrapped value</h2>
.get() to retrieve value
throws no such element exception
`Optional.of(year).filter(year -> year > 2016);`
returns Optional Object if match predicate or else empty object

<h2> Map</h2>

`listOptional.map(List::size)`

clean password using map transformation and filter out

`listOptional.map(String::trim)` -- remove for all password
When map returns a regular value and result wrap in new Optional

<h2> FlatMap</h2>

Takes wrapped value, unwrap and transform implicitly
`optional.flatMap(Person::getName).orElse()`
When transformation function returns an Optional and want to unwrap the optional.

<h2>Eager vs Lazy Evaluation</h2>
<h3>Eager</h3>
- `Stream.of(method1(),method2());`
<h3>Lazy</h3>
`Supplier<Optional<String>>.map(Supplier::get)` 
Only executed when result needed by stream operations.

<h2>Java 9 Enhancement</h2>
- `.or()` if Optional empty returns  an Optional(lazy chaining)
- `ifPresentOrElse()` Executes Consumer if present, runnable if empty
- `Optional.stream()` enable use Stream API method, empty stream if empty

<h2> When not to use</h2>

1. Optional as Parameter
   - solution: use as return type
2. Getters
3. Entity Beans
4. Data Model
5. DTO
6. Serializable
7. JSON
8. Serialized
9. JPA

Jackson modules:
Serialize using  ObjectMapper
 Methods of objectMapper
1. Serializing
- writeValueAsString
2. Deserializing
- mapper.readValue()







