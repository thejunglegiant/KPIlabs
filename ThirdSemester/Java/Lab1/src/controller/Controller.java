package controller;

import model.ShowModel;
import ui.ConsoleView;
import utils.ErrorInterceptor;
import utils.errors.WrongDateException;
import utils.errors.WrongStringException;

public class Controller {
    private final ShowModel model = new ShowModel();
    private final ConsoleView view = new ConsoleView();
    private final UserInput interceptor = new UserInput(view);

    public void run() {
        while (true) {
            view.printMenu();
            int choice = interceptor.inputInt(ConsoleView.INPUT_INT);
            switch (choice) {
                case 1:
                    view.printAll(model.getAll());
                    break;
                case 2:
                    try {
                        String actor = interceptor.inputString(ConsoleView.INPUT_ACTOR);

                        ErrorInterceptor.validString(actor);

                        view.printAll(model.getShowByActor(actor));
                    } catch (WrongStringException e) {
                        view.printMessage(e.getMessage());
                    }

                    break;
                case 3:
                    try {
                        String show = interceptor.inputString(ConsoleView.INPUT_SHOW);
                        String date = interceptor.inputString(ConsoleView.INPUT_DATE);

                        ErrorInterceptor.validString(show);
                        ErrorInterceptor.validDate(date);

                        view.printStrings(model.getTheaterByShowAndDate(show, date));
                    } catch (WrongStringException | WrongDateException e) {
                        view.printMessage(e.getMessage());
                    }

                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    view.printMessage(ConsoleView.WRONG_INPUT_INT);
            }
        }
    }
}
