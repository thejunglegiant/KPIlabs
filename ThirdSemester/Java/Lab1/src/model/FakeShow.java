package model;

import model.database.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeShow {
    private static final Random random = new Random();
    private static final String[] genres = { "Comedy", "Drama", "Horror", "Romantic", "Adventure", "Futuristic" };
    private static final String[] theaters = { "Shevchenko theater", "Pavlic theater",
            "National theater", "MyTheater", "Just another theater", "Lovely theater" };
    private static final String[] actors = { "Allerton", "Alston", "Altham", "Bentley", "Berkeley", "Beverley",
            "Marston", "Merton", "Middleton", "Milton" };

    public static Show getShow() {
        List<String> mainActors = new ArrayList<>();
        for (String name : actors) {
            if (random.nextInt(100) % 2 == 0) {
                mainActors.add(name);
            }
        }

        return new Show(
                "Show-" + random.nextInt(100),
                genres[random.nextInt(6)],
                theaters[random.nextInt(6)],
                random.nextInt(24) + ":" + random.nextInt(60),
                "2021-0" + random.nextInt(10) + "-" + (random.nextInt(21) + 10),
                random.nextInt(1000),
                random.nextInt(50),
                mainActors
        );
    }
}
