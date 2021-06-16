package com.codecool.restaurantmanagerprepa;

import com.codecool.restaurantmanagerprepa.restaurant.FactoryRestaurant;
import com.codecool.restaurantmanagerprepa.restaurant.Restaurant;

import java.util.Scanner;

public class restaurantApplication {

    public static Restaurant testRestaurant = FactoryRestaurant.getInstance("test");
    public static void main ( String[] args ) {

        String userInput;
        Scanner scanner = new Scanner(System.in);
        do {
            menu();
            userInput = scanner.nextLine();
            switch (userInput){
                case "1": getOrdersForCooking(); break;
                case "2": giveAwayFinishedOrders(); break;
                case "3": getOrdersForCooking(); break;
                            }

        } while (!userInput.equals("q"));
    }

    private static void giveAwayFinishedOrders () {
        testRestaurant.getChefGetOrdersFromWaiters();
    }

    private static void getOrdersForCooking () {
        testRestaurant.getWaitersGetOrdersFromGuests();
    }

    private static void menu () {
        System.out.println("Menu:");
        System.out.println("1. Get orders for cooking (Guests -> Waiters)");
        System.out.println("2. Give away finished orders (Chef -> Waiters)");
        System.out.println("3. Give away finished orders (Waiters -> Guests)");
        System.out.println("q - quit program");
    }
}
