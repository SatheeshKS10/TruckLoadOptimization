package com.truckoptimization.service.impl;

import com.truckoptimization.model.Item;
import com.truckoptimization.service.ItemComparator;

public class PriorityBasedItemSorter implements ItemComparator {

    @Override
    public int compare(Item item1, Item item2) {
        return item2.getPriority() - item1.getPriority();
    }
}
