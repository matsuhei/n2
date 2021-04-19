package main;

import main.iterator.ItemGenerator;

public class Main {

    public void main() {
        ItemGenerator itemGenerator = new ItemGenerator();

        System.out.println(itemGenerator.getItems().get(0).toString());
    }
}
