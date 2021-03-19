package utils.errors;

import java.io.IOException;

public class WrongDateException extends IOException {
    public WrongDateException(String message) {
        super(message);
    }
}
