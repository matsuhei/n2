package main;

import main.factory.Account;
import main.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountServiceTest {
    private final AccountService accountService = new AccountService();

    @Test
    public void getAccount() {
        Account account = accountService.getAccount();

        Assertions.assertEquals(account.getOwner().getName(), "john");
        Assertions.assertEquals(account.getOwner().getAge(), 10);
    }

    @Test
    public void createAccount() {
        Account account = accountService.createAccount("bob", 18);

        Assertions.assertEquals(account.getOwner().getName(), "bob");
        Assertions.assertEquals(account.getOwner().getAge(), 18);
    }
}
