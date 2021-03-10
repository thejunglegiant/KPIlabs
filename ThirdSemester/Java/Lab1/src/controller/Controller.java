package controller;

import model.ShowModel;
import model.database.Show;
import ui.ConsoleView;

public class Controller {
    private final ShowModel model = new ShowModel();
    private final ConsoleView view = new ConsoleView();
    private final UserInterceptor interceptor = new UserInterceptor(view);

    public void run() {
        while (true) {
            view.printMenu();
            int choice = interceptor.inputInt(ConsoleView.INPUT_INT);
            switch (choice) {
                case 1:
                    view.printAll(model.getAll());
                    break;
                case 2:
                    Show[] caseTwo = model.getShowByActor(interceptor.inputString(ConsoleView.INPUT_ACTOR));

                    if (caseTwo.length > 0) {
                        view.printAll(caseTwo);
                    } else {
                        view.printMessage(ConsoleView.NOTHING_FOUND);
                    }

                    break;
                case 3:
                    String[] caseThree = model.getTheaterByShowAndDate(
                            interceptor.inputString(ConsoleView.INPUT_SHOW),
                            interceptor.inputDate()
                    );

                    if (caseThree.length > 0) {
                        view.printStrings(caseThree);
                    } else {
                        view.printMessage(ConsoleView.NOTHING_FOUND);
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
