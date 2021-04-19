package main.adapter;

import main.bean.Human;
import main.bean.Student;

public class HumanAdapter extends Human implements Student {

    public HumanAdapter(String name, int age) {
        super(name, age);
    }

    // 生徒にはさん付けするように
    public String getName() {
        System.out.println("Adapter name: " + getHumanName());
        return getHumanName() + "さん";
    }

    public int getAge() {
        System.out.println("Adapter age: " + getHumanAge());
        return getHumanAge();
    }
}
