package com.shadowapp;

abstract class Order {
    String info = "You haven't made order";

    public String getInfo(){
        return info;
    }

    public abstract float getPrice();
}
