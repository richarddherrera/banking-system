package model;

public class Account {
    private Integer number;
    private Agency agency;
    private Client client;
    private Double balance;

    public Account() {
    }

    public Account(Integer number, Agency agency, Client client, Double balance) {
        this.number = 0001;
        this.agency = agency;
        this.client = client;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", agency=" + agency +
                ", client=" + client +
                ", balance=" + balance +
                '}';
    }
}
