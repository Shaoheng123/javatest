<h1> String Operations</h1>

<h3>What it does</h3>
Stream() converts to a stream of data

<h3>Joining Strings</h3>
`Arrays.asList(ArrayOfString).stream().collect(Collectors.joining(",""))`

<h3> Prefix and Suffix</h3>

`Arrays.asList(arrayOfString).stream().collect(Collectors.joining(",","[","]"));`

<h3> Splitting Strings</h3>

- `Stream.of(str.split",").map(elem -> new String(elem)).collect(Collectors.toList())`
- `str.chars().mapToObj(item -> (char) item).collect(Collectors.toList());`
<h3>String Array to map</h3>
- `Arrays.asList(arrayOfString).stream().map(str -> str.split(",").collect(Collectors.toMap(str->str[0],str->str[0]))`