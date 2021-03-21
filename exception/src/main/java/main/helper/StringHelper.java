package main.helper;

import java.util.Objects;

public class StringHelper {
    // Exceptionを吐き出す対象
    public static String getName() {
        return "name";
    }

    public static Integer length(String item) {
        if (Objects.isNull(item)) {
            throw  new NullPointerException();
        }
        return item.length();
    }
}
