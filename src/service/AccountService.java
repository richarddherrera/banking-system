package service;

import model.Account;

public class AccountService {

    public void deposit(Account account, double amount){
        account.setBalance(account.getBalance() + amount);
    }
}
