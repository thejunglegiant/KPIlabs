package ui;

import data.database.Show;

import java.util.Calendar;

public class ConsoleView {
    public static final String INPUT_INT = "Enter menu option - ";
    public static final String WRONG_INPUT_INT = "Wrong option.\nTry again - ";
    public static final String INPUT_ACTOR = "Enter actor's name - ";
    public static final String INPUT_SHOW = "Enter show's name - ";
    public static final String INPUT_DAY = "Enter day - ";
    public static final String INPUT_MONTH = "Enter month - ";
    public static final String INPUT_YEAR = "Enter year - ";

    public void printMessage(String message){
        System.out.print(message);
    }

    public void showArrayInformation(Show show){
        System.out.println(show.toString());
    }

    public void printMenu(){
        System.out.println();
        System.out.println("Menu");
        System.out.println("1 - All shows");
        System.out.println("2 - Shows by actor");
        System.out.println("3 - Theaters by specific show and date");
        System.out.println("4 - Exit");
    }

    public void printEmptyResponse(){
        System.out.println("Unfortunately, nothing found by your query");
    }

    public void printAll(Show[] shows) {
        System.out.format("%10s%15s%25s%10s%15s%10s%15s%100s\n",
                "Name", "Genre", "Theater", "Time", "Date", "Price", "Actors amount", "Main actors");
        for (Show item : shows) {
            if (item == null) break;
            System.out.format("%10s%15s%25s%10s%15s%10s%5s%100s\n",
                    item.getName(), item.getGenre(), item.getTheater(), item.getTime(),
                    item.getDate().get(Calendar.DAY_OF_MONTH) + "."
                            + item.getDate().get(Calendar.MONTH) + "."
                            + item.getDate().get(Calendar.YEAR),
                    item.getAvgPrice(), item.getAmountOfActors(), item.getMainActors());
        }
    }

    public void printAllTheaters(String[] theaters) {
        System.out.print("Theaters: ");
        for (String item : theaters) {
            if (item == null) break;
            System.out.print(item + ", ");
        }
    }
}
