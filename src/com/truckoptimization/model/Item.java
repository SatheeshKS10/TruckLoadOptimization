package com.truckoptimization.model;
public class Item {
    private String itemId;
    private Integer priority;
    private String position;
    private String deliveryLocation;
    private double length;

    public Item(String itemId, Integer priority, String deliveryLocation, double length){
        this.itemId = itemId;
        this.priority = priority;
        this.deliveryLocation = deliveryLocation;
        this.length = length;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getItemId() {
        return itemId;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getPosition() {
        return position;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", priority=" + priority +
                ", position='" + position + '\'' +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                ", length=" + length +
                '}';
    }
}
