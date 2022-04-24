package com.truckoptimization.service;

import com.truckoptimization.model.Item;

import java.util.List;

public interface ItemService {
    /**
     * Sort items based on the sort mode
     * @param unorderedItems
     * @param sortMode
     * @return
     */
    List<Item> sortItems(List<Item> unorderedItems, String sortMode);

    /**
     * Generate Items based on the total items count i
     * @param i
     * @return
     */
    List<Item> generateItems(int i);
}
