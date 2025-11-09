<h1> Arrays</h1>
<h2>Declaration</h2>

int[] arr = int arr[];

<h2>Initialization</h2>
- `int[] arr = new int[5];`
- `int[] arr = new int[]{1,2,3,4,5}`
- 
<h2>Iterate</h2>
- forEach loop
- for loop

<h2> Variable Arguments</h2>

- `void method(String... args){}`

<h2> Transformation</h2>

<h3> Array to arraylist</h3>

- `Arrays.asList(new Integer[]{})`

<h3> Stream to arrayList</h3>

- `Arrays.stream(new String[] {})`

<h3> Sorting Arrays</h3>

- `Arrays.sort(arr)`
- `Arrays.sort(arr,1),3,Comparators.reverseOrder`

<h3> Searching Arrays</h3>
  
- `Arrays.binarySearch(arr,4)`
- 
<h3> Concatenate</h3>

- `int[] result = new int[arr1.length + arr2.length];`
- `System.arraycopy(arr1,0,result,0,arr1.length);`
- `System.arraycopy(arr2,0,result,arr1.length,arr2.length;)`

<h3>Array Literal</h3>

- `int[] array = {1,2,3,4,5}`
- `var arr = new int[]{1,2,3,4,5}`

<h3>Default initialization values</h3>

- int ->0
- boolean -> false
- Object-> null
- 
<h3>Array methods</h3>
- `Arrays.fill(array,value)`
- `Arrays.fill(array,start,end,value)`
- `Arrays.copyOf(array,length);`
-`Arrays.setAll();`
- `Arrays.setAll(array,i-> i*2)`

<h3>Cloning</h3>

- `ArraysUtils.clone(array);`

<h3>2D Array</h3>

```
int[][] matrix = new int[2][5];
matrix[0][1] = 20;
```
<h3>Loop Initialization</h3>
```
for(;i<n;i++)
{
array[i] = i+2;
}
```

<h3> Stream API</h3>

- `IntStream.of(1,2,3).toArray();`
- `IntStream.range(0,3).mapToObj(i->IntStream.range(0,4).map(j->i*4+j).toArray()).toArray(int[][]:: new);` initialize 2D array

<h2> Arrays Utility Methods</h2>

- Creating
- Comparing
- Sorting
- Searching
- Streaming
- Transforming
- ParallelPrefix

<h3>Creating</h3>
- `Arrays.copyOf(original, newLength);`
- `Arrays.copyOfRange(original,from.to);`
- `Arrays.fill(array,value);`

<h3>Comparing Arrays</h3>
- `Arrays.equals()` non nested arrays(faster)
- `Arrays.deepEquals()` nested arrays
- `Arrays.hashCode()`
- `Arrays.deepHashCode()`

<h3>Sorting Arrays</h3>
- `Arrays.sort()`
- `Arrays.parallelSort(array)` multi-core systems

<h3>Searching Arrays</h3>
- `Arrays.binarySearch(array,key)`
- `Arrays.binarySearch(array,key,comparator)`

<h3> Streaming Arrays</h3>

- `Arrays.stream(array)`
- `Arrays.stream(array,start,end)`

<h3> Transforming Arrays</h3>

- `Arrays.toString(array)`
- `Arrays.deeptoString(array)`
- `Arrays.asList(array)`
- `Arrays.setAll(array,generator function)`Generation function takes index as input and return value to be set at that index

<h3>ParallelPrefix</h3>
- `Arrays.parallelPrefix(array,operator)`
- `Arrays.parallelPrefix(array,from,to,operator)`

