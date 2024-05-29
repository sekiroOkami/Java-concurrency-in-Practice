package org.concurrent.chapter4;

import net.jcip.annotations.ThreadSafe;

// Address object is confine within the Person object and accessed through synchronized methods, ensure thread safe
@ThreadSafe
public class Person {
    private final Address address;

    public Person(Address address) {
        this.address = address;
    }

    public synchronized String getStreet() {
        return address.getStreet();
    }

    public synchronized void setStreet(String street) {
        address.setStreet(street);
    }
}

class Address {
    private String street;

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
}
