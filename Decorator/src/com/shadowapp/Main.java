package com.shadowapp;

public class Main {

    public static void main(String[] args) {
        Order eating1 = new Breakfast();
        System.out.println(eating1.getInfo()+": "+eating1.getPrice());
        eating1=new FrenchFrie(eating1);
        System.out.println(eating1.getInfo()+": "+eating1.getPrice());
eating1=new Coffee(eating1);
        System.out.println(eating1.getInfo()+": "+eating1.getPrice());
        eating1=new Hamburger(eating1);
        System.out.println(eating1.getInfo()+": "+eating1.getPrice());

       Order eating2=new Dinner();
        System.out.println(eating2.getInfo()+": "+eating2.getPrice());
    eating2=new Cola(new Hamburger(new FrenchFrie(eating2)));
        System.out.println(eating2.getInfo()+": "+eating2.getPrice());
    }
}
