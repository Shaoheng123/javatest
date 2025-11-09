package org.example;

public class User implements Cloneable{
    Address address;
    String firstName;
    String lastName;

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address=address;
    }

    public User(User that) {
        this(that.getFirstName(), that.getLastName(),new Address(that.getAddress()));
    }
    //Test Clone
    @Override
    public User clone() {
        User user;
        try {
            user= (User)super.clone();
            user.setAddress(this.getAddress().clone());
        }
        catch (CloneNotSupportedException e) {
            user = new User(this.getFirstName(),this.getLastName(),this.getAddress().clone());
        }
            return user;
        }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
