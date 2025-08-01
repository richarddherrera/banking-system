package exceptions;

public class AccountNameException extends RuntimeException {

    private String message;

    public AccountNameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
