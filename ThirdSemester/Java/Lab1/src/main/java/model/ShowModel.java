package model;

import model.data.AppDatabase;
import model.data.Show;
import utils.errors.DbException;

import java.util.Arrays;

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

    public String[] getTheaterByShowAndDate(String show, String date) {
        Show[] shows = database.getAll();
        String[] result = new String[shows.length];
        int found = 0;

        for (Show item : shows) {
            if (item.getName().equals(show) && item.getDate().equals(date)) {
                result[found++] = item.getTheater();
            }
        }

        return Arrays.copyOf(result, found);
    }

    public void deleteItem(int index) {
        database.delete(database.getAll()[index]);
    }

    public void saveData() throws DbException {
        database.saveDb();
    }
}
