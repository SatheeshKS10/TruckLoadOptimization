package com.truckoptimization.service.impl;

import com.truckoptimization.model.Item;
import com.truckoptimization.model.Truck;
import com.truckoptimization.service.TruckService;

import java.util.ArrayList;
import java.util.List;

public class TruckServiceImpl implements TruckService {
    private List<Truck> availableTrucks = null;
    private final int[] truckLength = new int[]{7, 13, 17};

    /**
     * Generate trucks
     *
     * @param totalTrucks
     * @return
     */
    @Override
    public List<Truck> initTrucks(int totalTrucks) {
        if(totalTrucks <= 0){
            System.out.println("No Trucks available");
            System.exit(0);
        }
        int i = 1;
        int lengthIndex = 0;
        availableTrucks = new ArrayList<>();
        System.out.println("Available Trucks: ");
        while (i <= totalTrucks) {
            Truck truck = new Truck("Truck_" + i, new ArrayList<>(), truckLength[lengthIndex++]);
            availableTrucks.add(truck);
            i++;
            lengthIndex = lengthIndex < 2 ? lengthIndex++ : 0;
            System.out.println(truck.toString());
        }
        System.out.println();
        return availableTrucks;
    }

    /**
     * Load items to truck
     *
     * @param orderedItems
     * @return
     */
    @Override
    public List<Truck> loadItems(List<Item> orderedItems) {
//        if (availableTrucks == null || orderedItems == null || orderedItems.isEmpty()) {
//            System.exit(0);
//        }

        int truckIndex = 0;
        int itemIndex = 0;
        double freeSpace = availableTrucks.get(truckIndex).getLength();
        while (truckIndex < availableTrucks.size() && itemIndex < orderedItems.size()) {

            Item currItem = orderedItems.get(itemIndex);
            // check if current Item can be placed in the truck
            if (freeSpace >= currItem.getLength()) {
                currItem.setPosition("POS_" + (itemIndex + 1));
                availableTrucks.get(truckIndex).getItems().add(currItem);
                freeSpace = freeSpace - currItem.getLength();
                itemIndex++;
            } else {
                truckIndex++;
                if (truckIndex >= availableTrucks.size()) {
                    break;
                }
                freeSpace = availableTrucks.get(truckIndex).getLength();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(itemIndex < orderedItems.size()){
            System.out.println("Total Items unable to load: "+(orderedItems.size() - itemIndex+"\n"));
        }
        return availableTrucks;
    }
}
