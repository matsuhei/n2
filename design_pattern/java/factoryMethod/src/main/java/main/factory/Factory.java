package main.factory;

import main.bean.Owner;

public abstract class Factory {

    public final Product create(Owner owner) {
        Product product = createProduct(owner); // 情報を増やす場合ここを拡張
        registerProduct(product);
        return product;
    }

    protected abstract Product createProduct(Owner owner);
    protected abstract void registerProduct(Product product);
}
