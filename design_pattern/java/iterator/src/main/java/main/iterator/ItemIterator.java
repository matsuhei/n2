package main.iterator;

import java.util.Iterator;
import java.util.List;

public class ItemIterator implements Iterator<Item> {

    private final ItemGenerator itemGenerator;
    private int idx;
    private final ItemType type;

    // Constructor
    public ItemIterator(ItemGenerator itemGenerator, ItemType type) {
        this.itemGenerator = itemGenerator;
        this.type = type;
        this.idx = -1;
    }

    @Override
    public boolean hasNext() {
        return findNextIdx() != -1;
    }

    @Override
    public Item next() {
        idx = findNextIdx();
        if (idx != -1) {
            return itemGenerator.getItems().get(idx);
        }
        return null;
    }

    private int findNextIdx() {
        List<Item> items = itemGenerator.getItems();
        int tempIdx = idx;
        while (true) {
            tempIdx++;
            if (tempIdx >= items.size()) {
                tempIdx = -1;
                break;
            }
            if (type.equals(ItemType.ANY) || items.get(tempIdx).getType().equals(type)) {
                break;
            }
        }
        return tempIdx;
    }
}
