package test;

import com.truckoptimization.model.Item;
import com.truckoptimization.service.ItemService;
import com.truckoptimization.service.impl.ItemServiceImpl;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PriorityBasedSortTest {

    private final ItemService itemService = new ItemServiceImpl();

    /**
     * Test priority based sort
     * descending order
     */
    @Test
    public void prioritySortTest() {
        List<Item> itemsList = initItems(5);
        itemsList = itemService.sortItems(itemsList, "PRIORITY");
        int lastPriority = Integer.MAX_VALUE;
        Assert.assertNotNull("Sorted Items are not null", itemsList);

        for (int i = 0; i < itemsList.size(); i++) {
            if (lastPriority < itemsList.get(i).getPriority()) {
                throw new AssertionFailedError("Priority based sort Failed");
            }
            lastPriority = itemsList.get(i).getPriority();
        }
    }

    private List<Item> initItems(int i) {
        return itemService.generateItems(i);
    }
}
