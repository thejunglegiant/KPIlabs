package data.database;

import data.FakeShow;

public class AppDatabase implements ShowDao {
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

    @Override
    public void insertAll(Show[] shows) {
        this.shows = shows;
    }

    @Override
    public void delete(Show item) {
        int index = -1;
        for (int i = 0; i < shows.length; i++) {
            if (shows[i] == item) {
                index = i;
                break;
            }
        }

        Show[] newShows = new Show[shows.length - 1];
        for (int i = 0; i < index; i++)
            newShows[i] = shows[i];

        for (int i = index + 1; i < newShows.length; i++)
            newShows[i] = shows[i];

        shows = newShows;
    }

    @Override
    public Show[] getAll() {
        return shows;
    }
}
