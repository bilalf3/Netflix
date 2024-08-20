package netflix;

import java.util.ArrayList;

public abstract class Material {
    int id;
    String name;
    ArrayList<Integer> scores;
    int releaseYear;
    int price;
    Category category;
    String type;

    public Material(int id, String name, ArrayList<Integer> scores, int releaseYear, int price, Category category, String type) {
        this.id = id;
        this.name = name;
        this.scores = scores;
        this.releaseYear = releaseYear;
        this.price = price;
        this.category = category;
        this.type = type;
    }

    public void addScore(int score) {
        this.scores.add(score);
    }

    public double getAvgScore() {
        if (this.scores.isEmpty()) return 0;
        int sum = 0;
        for (int score : this.scores) {
            sum += score;
        }
        return (double) sum / this.scores.size();
    }

    abstract void showDetail();
}
