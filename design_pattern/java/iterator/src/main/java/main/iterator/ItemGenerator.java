package main.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ItemGenerator {
    private final List<Item> items;

    // Constructor
    public ItemGenerator() {
        items = Arrays.asList(
            new Item(ItemType.ANY, "any"),
            new Item(ItemType.DIGITAL, "digital1"),
            new Item(ItemType.DIGITAL, "digital2"),
            new Item(ItemType.ANALOG, "analog")
        );
    }

    public Iterator<Item> iterator(ItemType itemType) {
        return new ItemIterator(this, itemType);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

}
