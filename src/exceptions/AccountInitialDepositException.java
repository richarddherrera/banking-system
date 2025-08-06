package exceptions;

public class AccountInitialDepositException extends RuntimeException {

  private String message;

  public AccountInitialDepositException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
