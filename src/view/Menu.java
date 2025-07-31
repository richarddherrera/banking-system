package view;

import enums.AgencyLocality;
import enums.Bank;
import exceptions.MainMenuException;
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

    public void showMainMenu() {
        boolean run = true;
        while (run){
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

                int optionMain = validator.validatorMainMenu(optionString);

                switch (optionMain) {
                    case 1 -> createAccount();

                    case 0 -> run = false;
                }

            }catch (MainMenuException e){
                System.out.println(e.getMessage());
            }
        }
    }


    public void createAccount() {

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your CPF (11 digits): ");
        String cpf = sc.nextLine();

        System.out.print("Enter your date of birth: ");
        String dateOfBirthString = sc.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Client client = new Client(name, cpf, dateOfBirth);
        System.out.println("Client created! ");

        Agency agency = new Agency(selectBank(), selectAgencyLocality());
        numberAgency(agency);
        System.out.println("Agency created! ");

        Account account = new Account(1, agency, client, randomBalance());
        bankingSystem.addAccount(account);


    }

    public Bank selectBank() {
        System.out.println("CHOOSE YOUR BANK");
        System.out.println("[1] - ITAÚ INIBANCO");
        System.out.println("[2] - BRADESCO");
        System.out.println("[3] - SANTANDER");

        int option = sc.nextInt();


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

    public Double randomBalance() {
        Random random = new Random();
        Double randomBalance = random.nextDouble(10.000);
        return randomBalance;
    }


}
