package com.shadowapp;

class FrenchFrie extends Decorator{
    Order order;

    public FrenchFrie(Order order){
        this.order = order;
    }

    public String getInfo() {
        return order.getInfo() + " + French frie";
    }

    public float getPrice() {
        return order.getPrice() + 2.8f;
    }
}
