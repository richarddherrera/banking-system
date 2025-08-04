package exceptions;

public class AccountBirthException extends RuntimeException {

    private String message;

    public AccountBirthException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
