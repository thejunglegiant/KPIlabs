package ui;

import model.data.Show;

interface MainView {
    void printMenu();
    void printMessage(String message);
    void printAll(Show[] shows);
    void printStrings(String[] strings);
}
