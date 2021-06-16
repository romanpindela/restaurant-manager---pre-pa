package com.codecool.restaurantmanagerprepa.person;

import com.codecool.restaurantmanagerprepa.order.Order;

import java.util.UUID;

public abstract class Person {
    protected String name;
    protected String uniqueID;

    public Person ( String name ) {
        this.name = name;
        this.uniqueID = createUniqueID();
    }

    public String createUniqueID(){
        return UUID.randomUUID().toString();
    }

    public abstract void interact(Person e);
}
