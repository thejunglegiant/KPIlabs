package model.database;

import model.FakeShow;

import java.util.Arrays;

public class AppDatabase {
    private Show[] shows;
    private static AppDatabase database;

    private AppDatabase() {
        shows = new Show[10];
        init();
    }

    private void init() {
        for (int i = 0; i < shows.length; i++)
            shows[i] = FakeShow.getShow();
    }

    public static AppDatabase getInstance() {
        if (database == null) {
            database = new AppDatabase();
        }

        return database;
    }

    public Show[] getAll() {
        return Arrays.copyOf(shows, shows.length);
    }

    public void setAll(Show[] shows) {
        this.shows = shows;
    }

    public void delete(Show item) {
        shows = Arrays.stream(shows).filter(show -> !show.toString().equals(item.toString())).toArray(Show[]::new);
    }
}
