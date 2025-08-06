package view;

import Utils.Formatter;
import enums.AgencyLocality;
import enums.Bank;
import exceptions.*;
import model.Account;
import model.Agency;
import model.Client;
import service.BankingSystem;
import Utils.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    BankingSystem bankingSystem = new BankingSystem();
    Validator validator = new Validator();
    Formatter formatter = new Formatter();

    public void showMainMenu() {
        boolean run = true;
        while (run) {
            try {
                System.out.println("\n=== BANKING MENU ===");
                System.out.println("[1] - Create new account");
                System.out.println("[2] - List accounts");
                System.out.println("[3] - Deposit");
                System.out.println("[4] - Withdraw");
                System.out.println("[5] - Transfer");
                System.out.println("[6] - View statement");
                System.out.println("[0] - Exit");
                System.out.print("Choose an option: ");
                String optionString = sc.nextLine().trim();
                System.out.println();
                int optionMain = validator.validatorMainMenu(optionString);

                switch (optionMain) {
                    case 1 -> createAccount();

                    case 0 -> run = false;
                }

            } catch (MainMenuException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void createAccount() {
        boolean run = true;
        String name = null;

        while (run) {
            try {
                System.out.print("Enter your name: ");
                name = validator.validatorAccountName(formatter.formatterString(sc.nextLine()));

                run = false;
            } catch (AccountNameException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error unexpected!");
            }
        }

        run = true;
        String cpf = null;
        while (run) {
            try {
                System.out.print("Enter your CPF (11 digits): ");
                cpf = validator.validatorAccountCpf(sc.nextLine());

                run = false;
            } catch (AccountCpfException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error unexpected!");
            }

        }

        run = true;

        LocalDate dateOfBirth = null;
        while (run){
            try {
                System.out.print("Enter your date of birth (yyyy-MM-dd): ");
                String dateOfBirthString = sc.nextLine();

                dateOfBirth = validator.validatorBirth(dateOfBirthString);

                run = false;
            }catch (AccountBirthException e){
                System.out.println(e.getMessage());
            }
        }

        Client client = new Client(name, cpf, dateOfBirth);

        Agency agency = new Agency(selectBank(), selectAgencyLocality());
        numberAgency(agency);
        System.out.println("Agency created! ");

        Account account = new Account(1, agency, client, initialDeposit());
        bankingSystem.addAccount(account);

    }

    public Bank selectBank() {
        boolean run = true;
        Bank bank = null;
        while (run){
            try {
                System.out.println("CHOOSE YOUR BANK");
                System.out.println("[1] - ITAÚ UNIBANCO");
                System.out.println("[2] - BRADESCO");
                System.out.println("[3] - SANTANDER");
                System.out.print("Choose an option: ");

                bank = validator.validatorBank(sc.nextLine());

                run = false;
            }catch (AgencyBankException e){
                System.out.println(e.getMessage());
            }
        }
        return bank;
    }

    public AgencyLocality selectAgencyLocality() {
        Random random = new Random();
        int numberRandom = random.nextInt(6) + 1;

        AgencyLocality optionAgencyLocality = null;

        switch (numberRandom) {
            case 1 -> {
                optionAgencyLocality = AgencyLocality.SP;
            }
            case 2 -> {
                optionAgencyLocality = AgencyLocality.RJ;
            }
            case 3 -> {
                optionAgencyLocality = AgencyLocality.BH;
            }
            case 4 -> {
                optionAgencyLocality = AgencyLocality.PoA;
            }
            case 5 -> {
                optionAgencyLocality = AgencyLocality.SSA;
            }
            case 6 -> {
                optionAgencyLocality = AgencyLocality.CWB;
            }
        }
        return optionAgencyLocality;
    }

    public void numberAgency(Agency agency) {
        Integer number = null;
        if (agency.getBank() == Bank.ITAU) {
            agency.setNumber(341);
        } else if (agency.getBank() == Bank.BRADESCO) {
            agency.setNumber(237);
        } else {
            agency.setNumber(441);
        }

    }

    public Double initialDeposit(){

        String option = null;
        boolean run = true;
        while (run){
            try {
                System.out.println("Do you want to make an initial deposit now?");
                System.out.println("[1] - YES");
                System.out.println("[2] - NO");
                System.out.print("Choose an option: ");
                option = sc.nextLine();
            }catch (AccountInitialDepositException e){
                System.out.println(e.getMessage());
            }
        }

        return validator.validatorInitialDeposit(option);
    }

}
