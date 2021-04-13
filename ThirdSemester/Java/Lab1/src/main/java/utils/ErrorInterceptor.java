package utils;

import utils.errors.WrongDateException;
import utils.errors.WrongStringException;

import java.util.regex.Pattern;

public class ErrorInterceptor {

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");

    public static void validString(String str) throws WrongStringException {
        if (str.isEmpty()) {
            throw new WrongStringException("The string can not be empty");
        }
    }

    public static void validDate(String date) throws WrongDateException {
        if (!DATE_PATTERN.matcher(date).matches()) {
            throw new WrongDateException("The date has to be in \"yyyy-mm-dd\" format");
        }
    }
}
