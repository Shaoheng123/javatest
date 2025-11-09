<h2>Shallow</h2>
- Only field values copied
- Any change in values of fields will affect the shallowcopy

- <h2>Deepcopy</h2>
- Copy Each mutable object
- -Not dependent on copied object
- Will not get modified on accident

<h2>Methods of creating Deep copy</h2>
<h3>Copy Constructor</h3>
Creates a new copy of mutable fields like objects using enw keyword.
```
public Address(Address that) {
    this(that.getStreet(), that.getCity(), that.getCountry());
}

public User(USer that) {
this(that.getFIrstName(), that.getLastName(), new Address(that.getAddress()));
}

User deepCopy = new User(pm);
``` 


<h3>CLoneable</h3>
implement marker Interface to indicate class is cloneable
```
 try {
        User user = (User) super.clone();
        user.setAddress(this.getAddress().clone()); // deep copy
        return user;
    } catch (CloneNotSupportedException e) {
        // fallback deep copy
        return new User(this.getFirstName(), this.getLastName(), this.getAddress().clone());
    }
    
```

<h2>Apache Common Lang:</h2>

Apache Commons Lang has SerializationUtils#clone, which performs a deep copy when all classes in the object graph implement the Serializable interface.

If the method encounters a class that isn’t serializable, it’ll fail and throw an unchecked SerializationException.

SerializationUtils.clone(pm)

All classes must implement Serializable interface



Json Serialization:

Gson is a library that’s used for converting objects into JSON and vice versa.

GSON does not need the Serializable interface to make the conversions. Additionally, transient fields are not permitted with Gson.



Jackson:

Add default constructor to class



Method:
```

ObjectMapper objectMapper = new ObjectMapper();

User deepCopy = objectMapper .readValue(objectMapper.writeValueAsString(pm), User.class);

```
<h2> Which method to use</h2>
The final decision will often depend on the classes we’ll copy, and whether we own the classes in the object graph.

