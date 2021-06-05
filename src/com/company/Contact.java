package com.company;

import java.io.Serializable;

public class Contact implements Serializable {

    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
