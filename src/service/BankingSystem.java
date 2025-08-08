package service;

import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankingSystem {

    private List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account){
        accountList.add(account);
    }

    public void removeAccount(Account account){
        accountList.remove(account);
    }

    public void listAccounts(){
        accountList.forEach(System.out::println);
    }

    public boolean lessTwo(){
        boolean confirm = false;
        if (accountList.size() < 2){
            confirm = true;
            System.out.println("You need to create two accounts, create them by typing [2].");
        }
        return confirm;
    }

    public List<Account> listDifferentAccount(int number){
        return accountList.stream().filter(account -> account.getNumber() != number).toList();
    }

    public Account findByAccountNumber(int numberAccount){

       return accountList.stream()
               .filter(account -> Objects.equals(account.getNumber(), numberAccount))
               .findFirst().orElse(null);
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
