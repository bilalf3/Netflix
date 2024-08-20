package netflix;

import java.util.ArrayList;

public class Movie extends Material {
    ArrayList<Person> actors;
    Person director;

    public Movie(int id, String name, ArrayList<Integer> scores, int releaseYear, int price, Category category, String type, ArrayList<Person> actors, Person director) {
        super(id, name, scores, releaseYear, price, category, type);
        this.actors = actors;
        this.director = director;
    }

    public void addActor(Person actor) {
        this.actors.add(actor);
    }

    @Override
    void showDetail() {
        System.out.println("Film: " + name + ", Yonetmen: " + director.firstName + " " + director.lastName + ", Ortalama Puan: " + getAvgScore());
    }
}
