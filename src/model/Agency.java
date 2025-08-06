package model;

import enums.AgencyLocality;
import enums.Bank;

public class Agency {
    private Bank bank;
    private AgencyLocality agencyLocality;
    private Integer number;

    public Agency() {
    }

    public Agency(Bank bank, AgencyLocality agencyLocality, Integer number) {
        this.bank = bank;
        this.agencyLocality = agencyLocality;
        this.number = number;
    }

    public Agency(Bank bank, AgencyLocality agencyLocality) {
        this.bank = bank;
        this.agencyLocality = agencyLocality;
    }


    public AgencyLocality getAgencyLocality() {
        return agencyLocality;
    }

    public void setAgencyLocality(AgencyLocality agencyLocality) {
        this.agencyLocality = agencyLocality;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format(
                "+----------------+---------------------------+\n" +
                        "| Field          | Value                     |\n" +
                        "+----------------+---------------------------+\n" +
                        "| Bank           | %-25s |\n" +
                        "| Locality       | %-25s |\n" +
                        "| Number         | %-25s |\n" +
                        "+----------------+---------------------------+",
                bank, agencyLocality, number
        );
    }


}
