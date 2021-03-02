package ui;

import data.database.Show;

interface MainView {
    void printMenu();
    void printMessage(String message);
    void printEmptyResponse();
    void printAll(Show[] shows);
    void printStrings(String[] strings);
}
