package org.example;

public class ShallowvsDeepCopy {
    public User shallowCopy() {
        Address address = new Address("Singapore","Singapore");
        User pm = new User("sh","te",address);
        return pm;
    }
}
