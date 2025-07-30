package service;

import model.Account;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    private final List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account){
        accountList.add(account);
    }

    public void removeAccount(Account account){
        accountList.remove(account);
    }

    public void listAccounts(Account account){
        accountList.forEach(System.out::println);
    }

}
