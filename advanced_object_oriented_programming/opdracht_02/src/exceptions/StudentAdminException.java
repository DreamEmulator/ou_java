package exceptions;

public class StudentAdminException extends Exception {

    public String message;
    public StudentAdminException() {
        super();
    }

    public StudentAdminException(String message) {
        super(message);
        this.message = message;
    }

    public StudentAdminException(String message, Throwable err) {
        super(message, err);
    }

}