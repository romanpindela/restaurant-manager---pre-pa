package com.codecool.restaurantmanagerprepa.person;

import com.codecool.restaurantmanagerprepa.Utils.MessageBroker;
import com.codecool.restaurantmanagerprepa.order.Order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Waiter extends Person{
    protected Map<Guest,Order> orders;

    protected Map<Guest,Order> finishedOrder;

    public Waiter ( String name, Map<Guest,Order> orders, Map<Guest,Order> finishedOrder) {
        super(name);
        this.orders = orders;
        this.finishedOrder = finishedOrder;
    }

    @Override
    public void interact (Person e) {
        if (e instanceof Guest){
            if (checkIfGuestHasFinishedOrder((Guest) e)) {
                serveFinishedOrder((Guest) e);
            }
            takeOrder((Guest) e );
        } else {
            MessageBroker.printConsole("Waiter: " + this.name + " : I can interact only with guests!");
        }
    }

    private void serveFinishedOrder ( Guest e ) {
        e.getFinishedOrder(giveFinishedOrder(e));
    }

    private boolean checkIfGuestHasFinishedOrder ( Guest e ) {
        return finishedOrder.containsKey(e);
    }

    private Optional<Order> giveFinishedOrder ( Guest e ) {
        Order returnOrder = finishedOrder.get(e);
        finishedOrder.remove(e);
        return Optional.of(returnOrder);
    }

    public boolean takeOrder ( Guest e ) {
        MessageBroker.printConsole("Waiter: " + this.name + " : I'm taking order from guest: " + e.name);
        Optional<Order> maybeOrder = e.getOrder();
        if (maybeOrder.isPresent()){
            this.orders.put(e, maybeOrder.get());
            return true;
        } else return false;
    }

    public Optional<Map<Guest,Order>> getOrders () {
        Map<Guest,Order> returnOptionalOrders = Map.copyOf(orders);
        return Optional.of(returnOptionalOrders);
    }

    public void clearOrders(){
        orders.clear();
    }

    public Optional<Map<Guest,Order>> getFinishedOrder () {
        return Optional.of(finishedOrder);
    }

    public void transferFinishedOrder ( Map<Guest,Order> finishedOrder ) {
        MessageBroker.printConsole("Waiter: " + this.name + " : I'm getting transferred finished order from chef");
        this.finishedOrder.putAll(finishedOrder);
    }

}
