package src;

import java.util.Collections;
import java.util.List;

public class Lottery {
    public List<String> list;

    public List<String> getList() {
        return this.list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }

    public static List<String> doLottery(List<String> list, Integer size) {
        Collections.shuffle(list);
        return list.subList(0, size);
    }
}
