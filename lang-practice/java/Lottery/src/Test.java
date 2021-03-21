package src;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        lottery.setList(list);

        List<String> result = Lottery.doLottery(list, 2);
        System.out.println(result.toString());
        System.out.println(result.size() == 2);
    }
}