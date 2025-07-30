package model;

import java.time.LocalDate;

public class Client {
    private String name;
    private String cpf;
    private LocalDate dataOfBirth;

    public Client() {
    }

    public Client(String name, String cpf, LocalDate dataOfBirth) {
        this.name = name;
        this.cpf = cpf;
        this.dataOfBirth = dataOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataOfBirth=" + dataOfBirth +
                '}';
    }
}
