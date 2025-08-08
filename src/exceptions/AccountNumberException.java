package exceptions;

public class AccountNumberException extends RuntimeException {

  private String message;

  public AccountNumberException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
