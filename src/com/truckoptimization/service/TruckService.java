package com.truckoptimization.service;

import com.truckoptimization.model.Item;
import com.truckoptimization.model.Truck;

import java.util.List;

public interface TruckService {
    /**
     * Generate trucks based on the total trucks
     * @param totalTrucks
     * @return
     */
    List<Truck> initTrucks(int totalTrucks);

    /**
     * Load Items to truck based on the sorted order
     * @param orderedItems
     * @return
     */
    List<Truck> loadItems(List<Item> orderedItems);
}
