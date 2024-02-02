package PriorityQueueArray;

import java.util.ArrayList;
import java.util.List;

class Item {
    public int value;
    public int priority;

    public Item() {}

    public Item(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}

public class PriorityQueueArray {
    private Item item;
    private List<int[]> arr;
    public PriorityQueueArray() {
        this.arr = new ArrayList<>();
        this.item = new Item();
    }

    
}
