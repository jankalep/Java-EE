package com.shadowapp;

class Coffee extends Decorator{
    Order order;

    public Coffee(Order order){
        this.order = order;
    }

    public String getInfo() {
        return order.getInfo() + " + Coffee";
    }

    public float getPrice() {
        return order.getPrice() + 3.2f;
    }
}