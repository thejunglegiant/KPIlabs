package domain;

import data.ShowModel;
import data.database.Show;
import ui.ConsoleView;

public class Controller {
    private final ShowModel model = new ShowModel();
    private final ConsoleView view = new ConsoleView();
    private final UserInterceptor interceptor = new UserInterceptor(view);
    private int choice;

    public void run() {
        while (choice != 4) {
            view.printMenu();
            choice = interceptor.inputInt(ConsoleView.INPUT_INT);
            switch (choice) {
                case 1:
                    view.printAll(model.getAll());
                    break;
                case 2:
                    Show[] caseTwo = model.getShowByActor(
                            interceptor.inputString(ConsoleView.INPUT_ACTOR)
                    );

                    if (caseTwo.length > 0) {
                        view.printAll(caseTwo);
                    } else {
                        view.printEmptyResponse();
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
                        view.printEmptyResponse();
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
