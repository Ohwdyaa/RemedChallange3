package org.binar;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<FoodOrders> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addOrder(FoodOrders order) {
        this.orders.add(order);
    }
    public List<FoodOrders> getOrders() {
        return orders;
    }

}
