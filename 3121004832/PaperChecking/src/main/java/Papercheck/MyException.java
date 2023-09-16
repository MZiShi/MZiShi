package Papercheck;

public class MyException extends RuntimeException{
    private final String errMessage;
    public MyException(String message) {
        super(message);
        this.errMessage=message;
    }
    public String getErrMessage() {
        return errMessage;
    }

}
