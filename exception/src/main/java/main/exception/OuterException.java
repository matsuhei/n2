package main.exception;

public class OuterException extends Exception {
    /**
     * 外向け用上位Exception
     * @param message
     */
    public OuterException(String message) {
        super(message);
    }
}
