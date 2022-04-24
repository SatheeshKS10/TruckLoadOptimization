package com.truckoptimization.service.impl;

import com.truckoptimization.service.ItemComparator;

public class ItemsComparatorFactory {
    /**
     * Factory method to create comparator instance based on the chosen sorting mode
     *
     * @param mode
     * @return
     */
    public ItemComparator chooseSortingMode(String mode) {
        switch (mode) {
            case "PRIORITY":
                System.out.println("Items are ordered based on Priority Highest to Lowest...!");
                return new PriorityBasedItemSorter();
            case "DELIVERY":
                System.out.println("Items are ordered based on Delivery...!");
                return new DeliveryLocationBasedItemSorter();
            default:
                throw new IllegalArgumentException("Not a valid option - choose either PRIORITY, DELIVERY");
        }
    }
}
