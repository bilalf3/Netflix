package netflix;

import java.util.ArrayList;

public class Book extends Material {
    Person writer;
    int numberOfPages;

    public Book(int id, String name, ArrayList<Integer> scores, int releaseYear, int price, Category category, String type, Person writer, int numberOfPages) {
        super(id, name, scores, releaseYear, price, category, type);
        this.writer = writer;
        this.numberOfPages = numberOfPages;
    }

    public void setWriter(Person newWriter) {
        this.writer = newWriter;
    }

    @Override
    void showDetail() {
        System.out.println("Kitap: " + name + ", Yazari: " + writer.firstName + " " + writer.lastName + ", Ortalama Puan: " + getAvgScore());
    }
}
