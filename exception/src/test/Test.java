package test;

import java.util.Arrays;

import main.Main;
import main.Exception.TestException;

public class Test {
    public static void main(String[] args) {
        System.out.println(Main.name());

        try {
            Main.validateBalance(100, 1000);
        } catch (TestException e) {
            System.out.println(e.getMessage() == "金額が足りません");
        }

        try {
            System.out.println(Arrays.toString(Main.gen(300)));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

            System.out.println(e.getMessage() == "Index 256 out of bounds for length 256");
        }
    }
}
