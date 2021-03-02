package domain;

import ui.ConsoleView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class UserInterceptor {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleView view;

    public UserInterceptor(ConsoleView view) {
        this.view = view;
    }

    public int inputInt(String msg) {
        view.printMessage(msg);
        while(!scanner.hasNextInt()) {
            view.printMessage(ConsoleView.WRONG_INPUT_INT);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String inputString(String type) {
        view.printMessage(type);
        return scanner.next();
    }

    public Calendar inputDate() {
        int day = inputInt(ConsoleView.INPUT_DAY);
        int month = inputInt(ConsoleView.INPUT_MONTH);
        int year = inputInt(ConsoleView.INPUT_YEAR);
        return new GregorianCalendar(year, month, day);
    }
}
