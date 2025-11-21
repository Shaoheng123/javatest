<h2> Generics (Java 5)</h2>

- Type parameter
  - different type parameters surrounded by commas
  - `public <T,G> List<G> method(T[]G, Function<T,G>)`
    -type para
  
<h3> Bounded Generic</h3>
  
- Restrict types that method accepts
  - `public<T extends Number>`
  - `public void method(List<? super Number>)`

<h2> Multiple Bounds</h2>

`<T extends Number & Comparable>`

<h2> WildCards</h2>
unknown type

<h3> Type Erasure</h3>

<h3>Primitive Data type</h3>

- Does not extend objects
- box as integer, boxed type

<h2> Casting</h2>

| Upper                    | Lower                     |
|--------------------------|---------------------------|
| List<? extends Building> | List<? super Building>    |
| Any subtype of building  | Any supertype of Building |

