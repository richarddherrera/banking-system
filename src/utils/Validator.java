package utils;

import enums.Bank;
import exceptions.*;
import model.Account;
import service.BankingSystem;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validator {

    Scanner sc = new Scanner(System.in);

    public int validatorMainMenu(String option) throws MainMenuException {


        if (option.isBlank()){
            throw new MainMenuException("\n ⚠ The option cannot be empty or null! \n");
        }

        if (!option.matches("^\\d+$")){
            throw new MainMenuException("\n ⚠ The option cannot contain letters or symbols! (Choose a number from the menu) \n") ;
        }

        int optionInt = Integer.parseInt(option);


        if (optionInt < 0 || optionInt > 6){
            throw new MainMenuException("\n ⚠ The option must be between 0 and 6! \n");
        }


        return optionInt;
    }

    public String validatorAccountName(String name) throws AccountNameException {

        if (name.isBlank()) {
            throw new AccountNameException("\n ⚠ The name cannot be empty or null \n");
        }

        if (!name.matches("^[\\p{L}\\s]+$")) {
            throw new AccountNameException("\n ⚠ The name cannot contain numbers or symbols! \n");
        }

        if(name.length() > 80 ) {
            throw new AccountNameException("\n ⚠ The name cannot be longer than 80 characters! \n");
        }

        if(name.length() < 3) {
            throw new AccountNameException("\n ⚠ The name cannot contain less than 3 characters! \n");
        }

        return name;
    }

    public String validatorAccountCpf(String cpf) throws AccountCpfException{

        if (cpf.isBlank()){
            throw new AccountCpfException("\n ⚠ The CPF cannot be empty or null! \n");
        }

        if (!cpf.matches("^\\d+$")){
            throw new AccountCpfException("\n ⚠ The CPF cannot contain letters or symbols! \n") ;
        }

        if (cpf.length() != 11){
            throw new AccountCpfException("\n ⚠ The CPF must contain than 11 characters! \n");
        }

        //  Verificando dígitos repetidos!
        if (cpf.chars().distinct().count() == 1){
            throw new AccountCpfException("\n ⚠ Invalid CPF: all digits are the same. \n");
        }

        // Verificar o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }

        int digito1 = 0;
        if (soma % 11 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - (soma % 11);
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = (soma % 11 < 2) ? 0 : 11 - (soma % 11);

        // Verifica se os dígitos batem
        if (cpf.charAt(9) - '0' != digito1 || cpf.charAt(10) - '0' != digito2) {
            throw new AccountCpfException("\n ⚠ Invalid CPF: incorrect verification digits! \n");
        }

        return cpf;

    }

    public LocalDate validatorBirth(String dateOfBirthString) throws AccountBirthException{

        if (dateOfBirthString.isBlank()){
            throw new AccountBirthException("\n ⚠ The date of birth cannot be empty or null! \n");
        }

        LocalDate dateOfBirth;

        try {
            dateOfBirth = LocalDate.parse(dateOfBirthString, DateTimeFormatter.ISO_LOCAL_DATE);
        }catch (DateTimeException e){
            throw new AccountBirthException("\n ⚠ Date of birth must be in this format (yyyy-MM-dd)! \n");
        }

        Period period = Period.between(dateOfBirth, LocalDate.now());

        if (period.getYears() < 18){
            throw new AccountBirthException("\n ⚠ Must be 18 years of age! \n");
        }

        return dateOfBirth;
    }

    public Bank validatorBank(String optionString) throws AgencyBankException {

        if (optionString.isBlank()){
            throw new AgencyBankException("\n ⚠ The option cannot be empty or null! \n");
        }

        if (!optionString.matches("^\\d+$")){
            throw new AgencyBankException("\n ⚠ The option cannot contain letters or symbols! \n") ;
        }

        int option = Integer.parseInt(optionString);

        if (option > 3 || option < 1){
            throw new AgencyBankException("\n ⚠ The option must be between 1 and 3! \n");
        }

        Bank optionBank = null;
        switch (option) {
            case 1 -> {
                optionBank = Bank.ITAU;
            }
            case 2 -> {
                optionBank = Bank.BRADESCO;
            }
            case 3 -> {
                optionBank = Bank.SANTANDER;
            }
        }

        return optionBank;
    }

    public Double validatorInitialDeposit(String option) throws AccountInitialDepositException {

        if (option.isBlank()){
            throw new AccountInitialDepositException("\n ⚠ The option cannot be empty or null! \n");
        }

        if (!option.matches("^\\d+$")){
            throw new AccountInitialDepositException("\n ⚠ The option cannot contain letters or symbols! (Choose a number from the menu) \n") ;
        }

        int optionInt = Integer.parseInt(option);

        if (optionInt < 1 || optionInt > 2){
            throw new AccountInitialDepositException("\n ⚠ The option must be between 1 and 2! \n");
        }

        double amount = 0.0;
        if (optionInt == 1) {

            boolean run = true;
            while (run){
                try {
                    System.out.print("Enter initial deposit amount:");
                    amount = validatorAmount(sc.nextLine());

                    run = false;
                }catch (AccountAmountException e){
                    System.out.println(e.getMessage());
                }
            }

        }else {
            amount = validatorAmount("0");
        }

        return amount;
    }

    // Validar a quantia deposito
    public Double validatorAmount(String amountString) throws AccountAmountException{

        if(amountString.isBlank()){
            throw new AccountAmountException("\n ⚠ The amount cannot be empty or null! \n");
        }

        if (!amountString.matches("^\\d+$")){
            throw new AccountAmountException("\n ⚠ The amount cannot contain letters or symbols! \n") ;
        }

        double amount = Double.parseDouble(amountString);

        if (amount < 0){
            throw new AccountAmountException("\n ⚠ The amount cannot be less than 0! \n");
        }

        return amount;
    }

    public Account validatorNumber(String numberAccount, BankingSystem bankingSystem)throws AccountNumberException{

        if (numberAccount.isBlank()){
            throw new AccountNumberException("\n ⚠ The number account cannot be empty or null! \n");
        }

        if (!numberAccount.matches("^\\d+$")){
            throw new AccountNumberException("\n ⚠ The number account cannot contain letters or symbols! \n");
        }

        int numberAccountInt = Integer.parseInt(numberAccount);

        Account account = bankingSystem.findByAccountNumber(numberAccountInt);

        if (account == null){
            throw new AccountNumberException("\n ⚠ The account was not found! \n");
        }

        return account;

    }

    public void validatorTransfer(Account accountSender, Account accountRecipient) throws AccountTransferException{
        if (accountRecipient.getNumber() == accountSender.getNumber()){
            throw new AccountTransferException("\n ⚠ The recipient's number cannot be the same as the sender's! \n");
        }
    }



    }


