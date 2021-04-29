package ui;

import model.data.Show;

public class ConsoleView implements MainView {
    public static final String INPUT_INT = "Enter menu option - ";
    public static final String WRONG_INPUT = "Wrong option.\nTry again - ";
    public static final String INPUT_ACTOR = "Enter actor's name - ";
    public static final String INPUT_SHOW = "Enter show's name - ";
    public static final String INPUT_DATE = "Enter date in \"yyyy-mm-dd\" format - ";
    public static final String INPUT_FILENAME = "Enter filename: ";
    public static final String NOTHING_FOUND = "Unfortunately, nothing found by your request.";
    public static final String ASK_SAVE = "Save result? (Y\\n): ";
    public static final String FAILED_MESSAGE = "Something went wrong.";

    @Override
    public void printMenu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1 - All shows");
        System.out.println("2 - Shows by actor");
        System.out.println("3 - Theaters by specific show and date");
        System.out.println("4 - Exit");
    }

    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void printAll(Show[] shows) {
        if (shows.length > 0) {
            System.out.format("%10s%15s%25s%10s%15s%10s%15s%100s\n",
                    "Name", "Genre", "Theater", "Time", "Date", "Price", "Actors amount", "Main actors");
            for (Show item : shows) {
                System.out.format("%10s%15s%25s%10s%15s%10s%5s%100s\n",
                        item.getName(), item.getGenre(), item.getTheater(), item.getTime(), item.getDate(),
                        item.getAvgPrice(), item.getAmountOfActors(), item.getMainActors());
            }
        } else {
            System.out.println(NOTHING_FOUND);
        }
    }

    @Override
    public void printStrings(String[] strings) {
        if (strings.length > 0) {
            System.out.print("Theaters: ");
            for (String item : strings) {
                System.out.print(item + ", ");
            }
        } else {
            System.out.println(NOTHING_FOUND);
        }
    }
}
