package model.data;

import model.FakeShow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.errors.DbException;

import java.io.*;
import java.util.Arrays;

public class AppDatabase {
    private final Logger logger = LogManager.getLogger(AppDatabase.class);
    private static final String dbPath = "src/main/resources/db.dat";
    private static AppDatabase database;
    private Show[] shows;

    public static AppDatabase getInstance() {
        if (database == null) {
            database = new AppDatabase();
        }

        return database;
    }

    private AppDatabase() {
        try {
            useDbBackup();
        } catch (DbException e) {
            logger.error(e.getMessage());
            init();
        }
    }

    private void useDbBackup() throws DbException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(dbPath))) {
            shows = ((Show[]) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new DbException("DB file does not exist or is damaged.");
        }
    }

    private void init() {
        shows = new Show[10];
        for (int i = 0; i < shows.length; i++)
            shows[i] = FakeShow.getShow();
    }

    public void saveDb() throws DbException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dbPath))) {
            objectOutputStream.writeObject(shows);
        } catch (IOException e) {
            throw new DbException("Saving data failed.");
        }
    }

    public Show[] getAll() {
        return Arrays.copyOf(shows, shows.length);
    }

    public void delete(Show item) {
        shows = Arrays.stream(shows).filter(show -> !show.toString().equals(item.toString())).toArray(Show[]::new);
    }
}
