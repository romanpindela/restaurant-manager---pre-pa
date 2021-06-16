package com.codecool.restaurantmanagerprepa.restaurant;

import com.codecool.restaurantmanagerprepa.order.Order;
import com.codecool.restaurantmanagerprepa.person.Chef;
import com.codecool.restaurantmanagerprepa.person.FactoryPerson;
import com.codecool.restaurantmanagerprepa.person.Guest;
import com.codecool.restaurantmanagerprepa.person.Waiter;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class FactoryRestaurant {

    public static Restaurant getInstance ( String restaurantType ){
        if (restaurantType.equals("test")){
            Chef chef = (Chef) FactoryPerson.getInstance("Wi-Chan", "Chef");
            List<Waiter> waiters = hireWaitersForTest();
            List<Guest> guests = hireGuestsForTest();
            List<Order> orders = createOrders();
            assignGuestOrder(guests, orders);

            guests.get(0).interact(guests.get(1));
            guests.get(0).interact(waiters.get(1));
            chef.interact(guests.get(0));
            return new RestaurantImpl (chef,  waiters,  guests );
        } else {
            return new RestaurantImpl((Chef) FactoryPerson.getInstance("Chef", "Chef"), new ArrayList<Waiter> (), new ArrayList<Guest> ());
        }
    }

    private static List<Guest> hireGuestsForTest () {
        return List.of (
                (Guest) FactoryPerson.getInstance("Andy","Guest"),
                (Guest) FactoryPerson.getInstance("Helen","Guest"),
                (Guest) FactoryPerson.getInstance("Felicia","Guest"),
                (Guest) FactoryPerson.getInstance("Kate","Guest"),
                (Guest) FactoryPerson.getInstance("Ron","Guest"),
                (Guest) FactoryPerson.getInstance("Kali","Guest"),
                (Guest) FactoryPerson.getInstance("Ben","Guest")
        );
    }

    private static List<Waiter> hireWaitersForTest () {
        return List.of (
                (Waiter) FactoryPerson.getInstance("Bob","Waiter"),
                (Waiter) FactoryPerson.getInstance("Lucy","Waiter")
        );
    }

    private static List<Order> createOrders () {
        return List.of(
                new Order("Placki ziemniaczane"),
                new Order("Płatki z mlekiem"),
                new Order("Jajecznica z pomidarmi"),
                new Order("Zupa krem z brokuł"),
                new Order("Pizza margerita"),
                new Order("Ryba z frytkami"),
                new Order("Dane dnia")
        );
    }



    private static void assignGuestOrder ( List<Guest> guests, List<Order> orders ) {
        for (int i = 0; i < guests.size(); i++) {
            guests.get(i).setOrder(orders.get(i));
        }
    }

}
