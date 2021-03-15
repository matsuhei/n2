package main.Exception;

public class TestException extends Exception {

    private static final long serialVersionUID = 1L;
    private int shortage;

    /**
     * 例外メッセージと不足金額
     */
    public TestException(String message, int shortage) {
        super(message);
        this.shortage = shortage;
    }

    public int getShortage() {
        return this.shortage;
    }
}