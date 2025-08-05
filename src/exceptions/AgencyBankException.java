package exceptions;

public class AgencyBankException extends RuntimeException {

    private String message;

    public AgencyBankException(String message) {
        this.message = message;
    }

  @Override
  public String getMessage() {
    return message;
  }
}
