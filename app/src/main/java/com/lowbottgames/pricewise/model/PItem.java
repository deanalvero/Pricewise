package com.lowbottgames.pricewise.model;

public class PItem {
    private double price;
    private double unit;

    public PItem(double price, double unit){
        this.price = price;
        this.unit = unit;
    }

    public double getPrice(){ return this.price; }
    public double getUnit(){ return this.unit; }
    public double getRatio(){ return this.price / this.unit; }

}
