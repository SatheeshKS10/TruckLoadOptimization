package com.truckoptimization.service.impl;

import com.truckoptimization.model.Item;
import com.truckoptimization.service.ItemComparator;
import com.truckoptimization.service.ItemService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ItemServiceImpl implements ItemService {

    private final List<Integer> lengthData = Arrays.asList(3, 5, 2, 6);

    private ItemComparator getItemComparatorInstance(String sortMode) {
        ItemsComparatorFactory itemsComparatorFactory = new ItemsComparatorFactory();
        ItemComparator itemComparator = itemsComparatorFactory.chooseSortingMode(sortMode);
        return itemComparator;
    }

    /**
     * Order items
     *
     * @param unorderedItems
     * @param sortMode
     * @return
     */
    @Override
    public List<Item> sortItems(List<Item> unorderedItems, String sortMode) {
        if (unorderedItems == null || unorderedItems.isEmpty()) {
            System.exit(0);
        }
        // get comparator instance based on the type of sort mode
        ItemComparator itemComparator = getItemComparatorInstance(sortMode);
        PriorityQueue<Item> orderedItemsQueue = new PriorityQueue(itemComparator);
        unorderedItems.stream().forEach(item -> orderedItemsQueue.offer(item));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Item> itemsList = new ArrayList<>();
        //System.out.println("Ordered Items data: ");
        while (!orderedItemsQueue.isEmpty()) {
            Item item = orderedItemsQueue.poll();
            itemsList.add(item);
            System.out.println(item.toString());
        }
        return itemsList;
    }

    /**
     * Generate Items
     *
     * @param totalItems
     * @return
     */
    @Override
    public List<Item> generateItems(int totalItems) {
        if(totalItems <= 0){
            System.out.println("No Items available to load...!");
            System.exit(0);
        }
        List<Item> itemsList = new ArrayList<>();
        Random randomPriority = new Random(0);
        Random randomLength = new Random(0);
        System.out.println("Generated Items: ");
        for (int i = 1; i <= totalItems; i++) {
            Item item = new Item("Item_" + i, randomPriority.nextInt(10),
                    "loc_" + randomPriority.nextInt(10),
                    lengthData.get(randomLength.nextInt(4)));
            System.out.println(item.toString());
            itemsList.add(item);
        }
        System.out.println();
        return itemsList;
    }
}
