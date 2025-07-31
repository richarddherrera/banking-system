package exceptions;

public class MainMenuException extends RuntimeException {

    private String message;

    public MainMenuException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
