package main.factory;

import main.bean.Owner;

public class Account extends Product {

    private Owner owner;

    Account(Owner owner) {
        System.out.println("Create account: " + owner.toString());
        this.owner = owner;
    }

    public void use() {
        System.out.println("Use Name: " + owner.getName());
    }
    public Owner getOwner() {
        return owner;
    }
}