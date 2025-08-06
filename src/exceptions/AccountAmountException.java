package exceptions;

public class AccountAmountException extends RuntimeException {
    private String message;

    public AccountAmountException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
