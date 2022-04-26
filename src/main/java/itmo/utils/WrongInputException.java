package itmo.utils;

/**
 * класс, описывающий WrongInputException
 */
public class WrongInputException extends Exception {

    /**
     * WrongInputException
     */
    public WrongInputException() {
    }

    /**
     * @param message message
     */
    public WrongInputException(String message) {
        super(message);
    }
}
