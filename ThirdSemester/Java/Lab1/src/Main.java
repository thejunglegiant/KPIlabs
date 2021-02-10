import java.text.DateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Generating data
        final List<Show> shows = new ArrayList<>();

        String[] genres = { "Comedy", "Drama", "Horror", "Romantic", "Adventure", "Futuristic" };
        String[] theaters = { "Shevchenko theater", "Pavlic theater",
                "National theater", "MyTheater", "Just another theater", "Lovely theater" };
        String[] actors = { "Allerton", "Alston", "Altham", "Bentley", "Berkeley", "Beverley",
                "Marston", "Merton", "Middleton", "Milton" };
        Random random = new Random();

        for (int i = 1; i < 10; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2021, Calendar.MARCH, (int)(random.nextFloat() * 100 % 30));
            List<String> tmpActors = new ArrayList<>();
            for (String name : actors) {
                if (i > random.nextFloat() * 10 % actors.length) {
                    tmpActors.add(name);
                }
            }
            shows.add(
                    new Show(
                        "Show - " + i,
                        genres[i % (genres.length - 1)],
                        theaters[i % (theaters.length - 1)],
                        (int)(random.nextFloat() * 100 % 24) + ":" + (int)(random.nextFloat() * 100 % 60),
                        calendar,
                        (int)(random.nextFloat() * 1000),
                        (int)(random.nextFloat() * 100 % 50),
                        tmpActors
                    )
            );
        }

        // Task 1
        String neededActor = actors[2];
        System.out.println("\nShows with " + neededActor + " in main role:\n");
        for (Show show : shows) {
            if (show.getMainActors().contains(neededActor)) {
                System.out.println(show.toString());
            }
        }

        // Task 2
        Calendar neededDate = Calendar.getInstance();
        neededDate.set(2021, Calendar.MARCH, 23);
        System.out.println("\nShows on 23th March:\n");
        for (Show show : shows) {
            if (
                    show.getDate().get(Calendar.YEAR) == neededDate.get(Calendar.YEAR) &&
                    show.getDate().get(Calendar.MONTH) == neededDate.get(Calendar.MONTH) &&
                    show.getDate().get(Calendar.DAY_OF_MONTH) == neededDate.get(Calendar.DAY_OF_MONTH)
            ) {
                System.out.println(show.toString());
            }
        }
    }
}
