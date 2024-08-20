package netflix;

import java.util.ArrayList;
import java.util.List;

public abstract class Material {
    int id;
    String name;
    ArrayList<Integer> scores;
    int release_year;
    Category category;
    int price;
    String type; // "movie" veya  "book"

    public Material(int id, String name, ArrayList<Integer> scores, int release_year, int price, Category category, String type) {
        this.id = id;
        this.name = name;
        this.scores = scores;
        this.release_year = release_year;
        this.price = price;
        this.category = category;
        this.type = type;
    }

    // Puan ekleme işlemi
    public void addScore(int score) {
        this.scores.add(score);
    }

    // Ortalama puan hesaplama
    public double getAvgScore() {
        return scores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0); // Eğer hiç puan yoksa 0.0 döner.
    }

    public abstract void showDetail();
}
