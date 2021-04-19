package main.service;

import main.bean.Human;

public class HumanService {

    // もともと使ってたHuman取得メソッド
    public Human getHuman(String name, Integer age) {
        return new Human(name, age);
    }
}
