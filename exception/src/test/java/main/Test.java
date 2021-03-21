package main;

import java.util.Arrays;

import main.exception.OuterException;
import main.exception.TestException;

public class Test {
    public static void main(String[] args) {
        System.out.println(Main.name());

        try {
            Main.badPurchase(100, 1000);
        } catch (TestException e) {
            System.out.println(e.getMessage() == "金額が足りません");
        }

        System.out.println(Main.purchase(100, 1000) == null);
        System.out.println(Main.purchase(10000, 1000) == null);

        try {
            System.out.println(Main.getNameLength("100") == 3);
            System.out.println(Main.getNameLength(null));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Arrays.toString(Main.getIntStringList(10)));
            System.out.println(Arrays.toString(Main.getIntStringList(260)));
        } catch (OuterException e) {
            e.printStackTrace();
        }

        // 不変なオブジェクト利用
        System.out.println(Main.ImmutableObject().configA == "configA");


        try {
            System.out.println(Arrays.toString(Main.gen(300)));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

            System.out.println(e.getMessage() == "Index 256 out of bounds for length 256");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
