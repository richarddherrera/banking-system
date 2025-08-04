package exceptions;

public class AccountCpfException extends RuntimeException {

    private String message;

    public AccountCpfException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
