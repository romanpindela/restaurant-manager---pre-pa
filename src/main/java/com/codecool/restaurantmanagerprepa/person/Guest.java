package com.codecool.restaurantmanagerprepa.person;

import com.codecool.restaurantmanagerprepa.Utils.MessageBroker;
import com.codecool.restaurantmanagerprepa.order.Order;

import java.util.Optional;

public class Guest extends Person{

    private Order order;

    public Guest ( String name ) {
        super(name);
    }

    @Override
    public void interact (Person e) {
        if (e instanceof Guest){
            switchOrder(((Guest) e));
        } else {
            MessageBroker.printConsole("Guest: " + this.name + " : I can interact only with guest!");
        }

    }

    protected Optional<Order> getOrder (){
        return Optional.of(order);
    }

    public void setOrder ( Order order ) {
            this.order = order;
    }

    protected void switchOrder(Guest e){
        MessageBroker.printConsole("Guest: " + this.name + " : I'm switching order with: " + e.name);

        Optional<Order> maybeSwitchedOrderThat = e.getOrder();
        Optional<Order> maybeSwitchedOrderThis = this.getOrder();

        if (maybeSwitchedOrderThat.isPresent()){
            this.setOrder(maybeSwitchedOrderThat.get());
        }
        if (maybeSwitchedOrderThis.isPresent()){
            e.setOrder(maybeSwitchedOrderThis.get());

        }
    }

    public void getFinishedOrder(Optional<Order> o){
        if ( o.isPresent() ) {
            MessageBroker.printConsole("Guest: " + this.name + " : I've received finished order! " + o.get().getName());
        }
        int x = 0;
    }
}
