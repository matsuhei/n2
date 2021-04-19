package main.bean;

public class Human {

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getHumanName() {
        return name;
    }

    public int getHumanAge() {
        return age;
    }
}
