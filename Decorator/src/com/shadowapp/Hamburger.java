package com.shadowapp;

class Hamburger extends Decorator{
    Order order;

    public Hamburger(Order order){
        this.order = order;
    }

    public String getInfo() {
        return order.getInfo() + " + Hamburger";
    }

    public float getPrice() {
        return order.getPrice() + 2.0f;
    }
}
