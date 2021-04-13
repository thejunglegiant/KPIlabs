package utils;

import model.data.Show;
import utils.errors.FileManagerException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {
    private static final String rootPath = "./savings/";

    public static void writeShows(String filename, Show[] shows) throws FileManagerException {
        File folder = new File(rootPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folder,  filename + ".txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            StringBuilder data = new StringBuilder();

            for (Show show : shows) {
                data.append('\n').append(show.toString());
            }

            fileOutputStream.write(data.toString().getBytes());
        } catch (IOException e) {
            throw new FileManagerException("Writing file failed.");
        }
    }

    public static void writeTheaters(String filename, String[] theaters) throws FileManagerException {
        File folder = new File(rootPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folder,  filename + ".txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            StringBuilder data = new StringBuilder();

            for (String theater : theaters) {
                data.append('\n').append(theater);
            }

            fileOutputStream.write(data.toString().getBytes());
        } catch (IOException e) {
            throw new FileManagerException("Writing file failed.");
        }
    }
}
