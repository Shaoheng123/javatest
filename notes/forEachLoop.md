<h1>ForEach</h1>
Iterate over a collection and perform action over all elements 
<h2>List</h2>

`void forEach(Consumer<? super T> action)`
`List.forEach()`
<h2> HashMap </h2>
`HashMap<Biconsumer<? super T> action>`
`NamesMap.forEach(key,value)->`
<h3>Iterating over EntrySet</h3>
`namesMap.entrySet.forEach(key,value)->`
<h2>Parallel Operation</h2>
`names.parallelStream().forEach(LOG:info)`

<h2>Exceptions</h2>
`Cannot modify collection`
- cannot remove
- No breaks or continue
- No counters
- No Access to index

<h2>Difference</h2>

- forEach: operation on collection element but no modification to collection
- for:individual element of collection and modify collection
- for(String a:b) manually specify how to iteration
- Collection does the iteration


