package data.database;

import java.util.Calendar;
import java.util.List;

public class Show {
    private final String name, genre, theater, time;
    private final Calendar date;
    private final double avgPrice;
    private final int amountOfActors;
    private final List<String> mainActors;

    public Show(String name, String genre, String theater, String time,
                Calendar date, double avgPrice, int amountOfActors, List<String> actors) {
        this.name = name;
        this.genre = genre;
        this.theater = theater;
        this.time = time;
        this.date = date;
        this.avgPrice = avgPrice;
        this.amountOfActors = amountOfActors;
        this.mainActors = actors;
    }

    @Override
    public String toString() {
        return "\n" + name + ":\n" +
                "Genre: " + genre + "\n" +
                "Theater: " + theater + "\n" +
                "Time: " + time + "\n" +
                "Date: " + date.get(Calendar.DAY_OF_MONTH) + "."
                    + date.get(Calendar.MONTH) + "."
                    + date.get(Calendar.YEAR) + "\n" +
                "Price: " + avgPrice + "\n" +
                "Actors amount: " + amountOfActors + "\n" +
                "Main actors: " + mainActors.toString();
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getTheater() {
        return theater;
    }

    public String getTime() {
        return time;
    }

    public Calendar getDate() {
        return date;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public int getAmountOfActors() {
        return amountOfActors;
    }

    public List<String> getMainActors() {
        return mainActors;
    }
}
