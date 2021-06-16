package com.codecool.restaurantmanagerprepa.person;

import com.codecool.restaurantmanagerprepa.Utils.MessageBroker;
import com.codecool.restaurantmanagerprepa.order.Order;

import java.util.List;
import java.util.Map;

public class Chef extends Person{
    protected Map<Guest,Order> orders;

    protected Map<Guest,Order> finishedOrder;

    public Chef ( String name, Map<Guest,Order> orders, Map<Guest,Order> finishedOrder ) {
        super(name);
        this.orders = orders;
        this.finishedOrder = finishedOrder;
    }


    @Override
    public void interact (Person e) {
        if (e instanceof Waiter){
            cookOrders();
            receiveOrder((Waiter) e);
            transferFinishedOrders((Waiter) e);
        } else {
            MessageBroker.printConsole("Chef: " + this.name + " : I can interact only with waiter!");
        }
    }

    protected void transferFinishedOrders ( Waiter e ) {
        Map<Guest, Order> finishedOrdersToTransfer =  Map.copyOf(this.finishedOrder);
        e.transferFinishedOrder(finishedOrdersToTransfer);
        this.finishedOrder.clear();
        MessageBroker.printConsole("Chef: " + this.name + " : I'm transferring orders to waiter : " + e.name);
    }

    protected void receiveOrder ( Waiter e ) {
        if (e.getOrders().isPresent()){
            this.orders.putAll(e.getOrders().get());
            e.clearOrders();
        }
        MessageBroker.printConsole("Chef: " + this.name + " : I've received order from waiter : " + e.name);

    }

    public void cookOrders(){
        for (Map.Entry<Guest, Order> guestOrder : orders.entrySet()){
                    cookOrder((Guest) guestOrder.getKey(), (Order) guestOrder.getValue());
        }
        orders.clear();

    }

    protected void cookOrder ( Guest g, Order o) {
        finishedOrder.put(g, o);
        MessageBroker.printConsole("Chef: " + this.name + " : I've cooked order :" + g.name + " -> " + o.getName());

    }
}
