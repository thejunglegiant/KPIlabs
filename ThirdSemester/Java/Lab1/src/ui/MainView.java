package ui;

import model.database.Show;

interface MainView {
    void printMenu();
    void printMessage(String message);
    void printAll(Show[] shows);
    void printStrings(String[] strings);
}
