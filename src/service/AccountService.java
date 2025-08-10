package service;

import exceptions.AccountTransferException;
import exceptions.AccountWithdrawException;
import model.Account;

public class AccountService {

    public void deposit(Account account, double amount){
        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(Account account, double amount){
        if (amount > account.getBalance()){
            throw new AccountWithdrawException("\n ⚠ The amount entered is greater than the balance in the account! \n");
        }else {
            account.setBalance(account.getBalance() - amount);
        }
    }

    public void transfer(Account accountSender, Account accountRecipient, Double amount){
        if (amount > accountSender.getBalance()){
            throw new AccountTransferException("\n ⚠ The amount entered is greater than the balance in the account! \n");
        }else {
            accountSender.setBalance(accountSender.getBalance() - amount);
            accountRecipient.setBalance(accountRecipient.getBalance() + amount);
        }
    }
}
