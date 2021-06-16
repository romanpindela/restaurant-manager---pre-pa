package com.codecool.restaurantmanagerprepa.restaurant;

import com.codecool.restaurantmanagerprepa.person.Chef;
import com.codecool.restaurantmanagerprepa.person.Guest;
import com.codecool.restaurantmanagerprepa.person.Waiter;

import java.util.List;

public abstract class Restaurant {
    protected Chef chef;
    protected List<Waiter> waiters;
    protected List<Guest> guests;

    public Restaurant ( Chef chef, List<Waiter> waiters, List<Guest> guests ) {
        this.chef = chef;
        this.waiters = waiters;
        this.guests = guests;
    }

    public abstract void getWaitersGetOrdersFromGuests();
    public abstract void getChefGetOrdersFromWaiters();
//    public abstract void getChefCookOrders();
}
