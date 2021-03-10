package model;

import model.database.AppDatabase;
import model.database.Show;

import java.util.Arrays;
import java.util.Calendar;

public class ShowModel {
    private final AppDatabase database;

    public ShowModel() {
        this.database = AppDatabase.getInstance();
    }

    public Show[] getAll() {
        return database.getAll();
    }

    public Show[] getShowByActor(String actor) {
        Show[] shows = database.getAll();
        Show[] result = new Show[shows.length];
        int found = 0;

        for (Show item : shows) {
            if (item.getMainActors().contains(actor)) {
                result[found++] = item;
            }
        }

        return Arrays.copyOf(result, found);
    }

    public String[] getTheaterByShowAndDate(String show, Calendar date) {
        Show[] shows = database.getAll();
        String[] result = new String[shows.length];
        int found = 0;

        for (Show item : shows) {
            if (item.getName().equals(show)
                    && item.getDate().get(Calendar.DAY_OF_MONTH) == date.get(Calendar.DAY_OF_MONTH)
                    && item.getDate().get(Calendar.MONTH) == date.get(Calendar.MONTH)
                    && item.getDate().get(Calendar.YEAR) == date.get(Calendar.YEAR)) {
                result[found++] = item.getTheater();
            }
        }

        return Arrays.copyOf(result, found);
    }

    public void deleteItem(int index) {
        database.delete(database.getAll()[index]);
    }
}
