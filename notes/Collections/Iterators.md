<h1> Iterators and ListIterators</h1>
Traversal and modification of elements

<h2> Iterator</h2>

`Iterator<String> iter = collection.iterator();`

<h3> Methods</h3>

- hasNext() :check
- next(): retrieve next
- remove()

<h3>Usage</h3>
```
while(iterator.hasNext()) {
    String next = iterator.next();
    if("Two".equals(next)) {
        iterator.remove();
    }
}
```

<h3> Lambda</h3>
- forEachRemaining
    - iterated over some
    - process without while(hasNext) loop
<h2>ListIterator</h2>
- hasPrevious() : Check if list has previous element
- previous: returns previous element and move cursor backwards
- previousIndex(): index of element returned by subsequent call to previous
- add()
- insert()
- set() : replace last returned

Traverse backwards and access indices

<h3> Usage Pattern</h3>

```
items.listIterator();
while(listIterator.hasNext()) {
    String next = listIterator.next();
    if("replace".equals(next)) {
        listIterator.set("replacing");
    }
}
listIterator.add("New");
```
```
while(listIterator.hasPrevious()) {
    listIterator.previous();
}
```

