package service;

import exceptions.AccountWithdrawException;
import model.Account;

public class AccountService {

    public void deposit(Account account, double amount){
        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(Account account, double amount){
        if (amount > account.getBalance()){
            throw new AccountWithdrawException("\n ⚠ The number account cannot be empty or null! \n");
        }else {
            account.setBalance(account.getBalance() - amount);
        }
    }
}
