package utils.errors;

import java.io.IOException;

public class WrongStringException extends IOException {
    public WrongStringException(String message) {
        super(message);
    }
}
