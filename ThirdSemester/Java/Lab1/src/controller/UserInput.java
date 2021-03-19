package controller;

import ui.ConsoleView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleView view;

    public UserInput(ConsoleView view) {
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
}
