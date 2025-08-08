package exceptions;

public class AccountWithdrawException extends RuntimeException {

    private String message;

    public AccountWithdrawException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
