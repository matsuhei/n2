package main.factory;

import main.bean.Owner;

import java.util.ArrayList;
import java.util.List;

public class AccountFactory extends Factory {

    private List owners = new ArrayList();

    protected Product createProduct(Owner owner) {
        return new Account(owner);
    }

    protected void registerProduct(Product product) {
        owners.add( ((Account)product).getOwner() );
    }

    public List getOwners() {
        return owners;
    }
}
