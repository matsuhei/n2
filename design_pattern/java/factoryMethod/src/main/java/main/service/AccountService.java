package main.service;

import main.bean.Owner;
import main.factory.Account;
import main.factory.AccountFactory;
import main.factory.Factory;

public class AccountService {
    private final Factory factory = new AccountFactory();

    public Account getAccount() {
        return (Account) factory.create(Owner.builder().name("john").age(10).build());
    }

    public Account createAccount(String name, Integer age) {
        return (Account) factory.create(Owner.builder().name(name).age(age).build());
    }
}
