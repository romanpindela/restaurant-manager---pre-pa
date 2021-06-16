package com.codecool.restaurantmanagerprepa.person;

import com.codecool.restaurantmanagerprepa.order.Order;

import java.util.HashMap;

public class FactoryPerson {
    public static Person getInstance(String name, String personType){
        return switch(personType.toLowerCase()){
            case "chef" -> new Chef(name, new HashMap<Guest, Order>(), new HashMap<Guest, Order>());
            case "waiter" -> new Waiter(name, new HashMap<Guest, Order>(), new HashMap<Guest, Order>());
            case "guest" -> new Guest(name);
            default -> throw new IllegalStateException("Unexpected value: " + personType);
        };
    }

}
