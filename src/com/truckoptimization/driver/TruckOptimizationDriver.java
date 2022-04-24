package com.truckoptimization.driver;

import com.truckoptimization.model.Item;
import com.truckoptimization.model.Truck;
import com.truckoptimization.service.ItemService;
import com.truckoptimization.service.TruckService;
import com.truckoptimization.service.impl.ItemServiceImpl;
import com.truckoptimization.service.impl.TruckServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class TruckOptimizationDriver {

    public enum sortMode {
        PRIORITY, DELIVERY
    }

    public static void main(String[] args) {

        ItemService itemService = new ItemServiceImpl();
        List<Item> unorderedItemsList = itemService.generateItems(10);
        List<Item> orderedItems = itemService.sortItems(unorderedItemsList, sortMode.PRIORITY.toString());
        System.out.println();

        TruckService truckService = new TruckServiceImpl();
        truckService.initTrucks(6);
        List<Truck> loadedTrucks = truckService.loadItems(orderedItems);

        System.out.println("Loaded Truck details: ");
        Optional.ofNullable(loadedTrucks).orElse(Collections.emptyList()).stream().forEach(truck -> {
            if (truck.getItems().isEmpty()) {
                System.out.println("Empty truck - " + truck.getTruckId() + " Length: " + truck.getLength());
            } else {
                System.out.println("Id: " + truck.getTruckId() + " Length: " + truck.getLength() + " Items: " + truck.getItems() + "\n");
            }
        });

    }
}
