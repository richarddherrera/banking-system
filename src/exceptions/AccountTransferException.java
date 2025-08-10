package exceptions;

public class AccountTransferException extends RuntimeException {

    private String message;

    public AccountTransferException(String message) {
        this.message = message;
    }

  @Override
  public String getMessage() {
    return message;
  }
}
