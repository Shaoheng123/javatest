package org.example;

import java.util.Optional;

public class Address implements Comparable<Address>{
    String city;
    String country;


    public Address(String singapore, String singapore1) {
        this.city = singapore;
        this.country = singapore1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Optional<String> getOptionalCountry() {
        return Optional.of(country);
    }


    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public int compareTo(Address o) {
        return this.country.compareTo(o.country);
    }
}
