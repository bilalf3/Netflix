package netflix;

import java.util.ArrayList;
import java.util.List;

public class Movie extends Material {
    ArrayList<Person> actors;
    Person director;

    public Movie(int id, String name, ArrayList<Integer> scores, int release_year, int price, Category category, String type, ArrayList<Person> actors, Person director) {
        super(id, name, scores, release_year, price, category, type);
        this.actors = actors;
        this.director = director;
    }

    // Aktör ekleme işlemi
    public void addActor(Person actor) {
        this.actors.add(actor);
    }

    @Override
    public void showDetail() {
        System.out.println("Film:  " + name);
        System.out.println("Yapimci: " + director.firstName + " " + director.lastName);
        System.out.println("Aktor: ");
        actors.stream()
                .forEach(actor -> System.out.println(actor.firstName + " " + actor.lastName));
        System.out.println("Ortalama Skor: " + getAvgScore());
        System.out.println("Fiyat: ₺" + price);
    }
}
