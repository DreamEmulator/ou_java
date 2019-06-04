package theaterdata;

public class TheaterException extends Exception {
    public TheaterException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
