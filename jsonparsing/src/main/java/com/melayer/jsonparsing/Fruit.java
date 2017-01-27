package com.melayer.jsonparsing;

import java.util.ArrayList;

/**
 * Created by aniruddha on 27/1/17.
 */

public class Fruit {

    private String color;
    private Integer price;
    private Boolean isFrom;
    private ArrayList<String> types;
    private Global global;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getFrom() {
        return isFrom;
    }

    public void setFrom(Boolean from) {
        isFrom = from;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", isFrom=" + isFrom +
                ", types=" + types +
                ", global=" + global +
                '}';
    }
}
