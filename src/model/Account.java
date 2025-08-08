package model;

public class Account {
    private Integer number;
    private Agency agency;
    private Client client;
    private Double balance;

    public Account() {
    }

    public Account(Integer number, Agency agency, Client client, Double balance) {
        this.number = number;
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
        return String.format(
                "\n+-----------------+---------+------------------+---------------+------------------------------+--------------+-------------+---------------+\n" +
                        "| Number Account  | Balance | Bank             | Agency Number | Locality                     | Client Name  | CPF         | Date of Birth |\n" +
                        "+-----------------+---------+------------------+---------------+------------------------------+--------------+-------------+---------------+\n" +
                        "| %-15s | $%-7.2f | %-16s | %-13s | %-28s | %-12s | %-11s | %-13s |\n" +
                        "+-----------------+---------+------------------+---------------+------------------------------+--------------+-------------+---------------+",
                number,
                balance,
                agency.getBank(),
                agency.getNumber(),
                agency.getAgencyLocality(),
                client.getName(),
                client.getCpf(),
                client.getDataOfBirth()
        );
    }


}





