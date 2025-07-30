package enums;

public enum Bank {
    ITAU("Itaú Unibanco"),
    BRADESCO("Bradesco"),
    SANTANDER("Santander");

    private final String nameFormated;

    Bank(String nameFormated){
        this.nameFormated = nameFormated;
    }

    public String getNameFormated() {
        return nameFormated;
    }

    @Override
    public String toString() {
        return nameFormated;
    }
}
