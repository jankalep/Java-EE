package com.shadowapp;

class Cola extends Decorator{
    Order order;

    public Cola(Order order){
        this.order = order;
    }

    public String getInfo() {
        return order.getInfo() + " + Cola";
    }

    public float getPrice() {
        return order.getPrice() + 2.2f;
    }
}
