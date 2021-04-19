import main.iterator.Item;
import main.iterator.ItemGenerator;
import main.iterator.ItemType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class IteratorTest {
    @Test
    public void test() {
        ItemGenerator itemGenerator = new ItemGenerator();
        Iterator<Item> itemIterator = itemGenerator.iterator(ItemType.DIGITAL);

        Assertions.assertEquals(itemIterator.next().toString(), "digital1");
        Assertions.assertEquals(itemIterator.next().toString(), "digital2");
    }
}
