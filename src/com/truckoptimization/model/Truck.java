package com.truckoptimization.model;

import java.util.List;

public class Truck {
    private String truckId;
    private List<Item> items;
    private double length;

    public Truck(String truckId, List<Item> itemList, double length){
        this.truckId = truckId;
        this.items = itemList;
        this.length = length;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckId='" + truckId + '\'' +
                ", items=" + items +
                ", length=" + length +
                '}';
    }
}
