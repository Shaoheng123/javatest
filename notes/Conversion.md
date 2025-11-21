<h1> Conversion </h1>

<h2> Convert InputStream to String</h2>



   
- StringBuilder 
  - ```
      InputStream inputStream= new ByteArrayInputStream(originalstream .getBytes())`
      StringBuilder sb = new StringBuilder(inputStream, StandardCharsets.UTF_8);`
- BufferedReader
  - ```
      try(Reader reader =  new BufferedReader(new InputStreamBuilder(inputStream, StandardCharsets.UTF_8)))
      while(cc = reader.read()!= -1) {
          textBuilder.append((char) c)
      }
  
      ```
    BufferedReader.lines()
  - lines use readlines
  - New lines: `\n or \r or \n\r`
Need to indicate EOL for String
```
InputStream inputStream = new ByteArrayInputStream(string.get);
String result =  new BufferedReader( new InputStreamReader(inputStream, standardCharset.UTF_8)).lines().collect(Collectors.joining("\n"));
```
```
InputStream.readAllBytes();
```
```
InputStream inputStream = new ByteArrayInputStream(string.getBytes());
= new String(inputStream.readAllBytes(),StandardCharsets.UTF_8);
```

<h3>Scanner</h3>
```
InputStream inputStream = new ByteArray(String.getBytes)
ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

```

```
byte[] data = new byte[1024];
while((nRead =inputStream.read(data,0,data.length))!= -1) {\
  buffer.write(data,0,nRead);
}
String result = new StringBuffer(buffer.toByteArray(),Standard_Charset.UTF_8);

```
<h3> java.nio.file.Files</h3>

`ByteArrayInputStream(string.getBytes());`

```
Path file = Files.createTempDirectory("").resolve(UUID.randomUUID);

```

Files.copy(inputStream,tempFIle,StandardCopyOption.Replace_Existing);
result = new String(File.readAllBytes(tempFile));

<h3>Apache Commons IO</h3>
```
String result = IOUtil.toString(inputStream, StandardCharset.UTF_8);
StringWriter writer = new StringWriter();
IOUtils.copy(inputStream,writer,StandardCharsets.UTF_8.name);
String result = writer.toString();
```
<h2> Convert List to Array</h2>

`list.toArray()`
<h3>Array to List</h3>
- `Arrays.asList();`

<h3>Apache Commons</h3>
- `CollectionUtil.addAll(list,sourceArray);`