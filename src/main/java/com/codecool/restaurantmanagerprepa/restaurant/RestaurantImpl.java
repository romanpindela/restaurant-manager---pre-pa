package com.codecool.restaurantmanagerprepa.restaurant;

import com.codecool.restaurantmanagerprepa.person.Chef;
import com.codecool.restaurantmanagerprepa.person.Guest;
import com.codecool.restaurantmanagerprepa.person.Waiter;

import java.util.List;
import java.util.Random;

public class RestaurantImpl extends Restaurant {

    public RestaurantImpl ( Chef chef, List<Waiter> waiters, List<Guest> guests ) {
        super(chef, waiters, guests);
    }

    @Override
    public void getWaitersGetOrdersFromGuests () {
        Random r = new Random();
        for (Guest g : guests){
//            waiters.get(r.nextInt(waiters.size())).takeOrder(g);
            waiters.get(r.nextInt(waiters.size())).interact(g);
        }
    }

    @Override
    public void getChefGetOrdersFromWaiters () {
        for ( Waiter w : waiters){
            chef.interact(w);
        }
    }

//    @Override
//    public void getChefCookOrders () {
//        chef.cookOrders();
//    }
}
