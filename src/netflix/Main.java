package netflix;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Birden çok Person nesnesi oluşturmak
        Person actor1 = new Person(1, "Bilal ", "Fettahlioglu", 45);
        Person actor2 = new Person(2, "Test", "Kisisi", 56);
        Person director1 = new Person(3, "BYapimci", "Tarantino", 57);
        Person writer1 = new Person(4, "Byazar", "Fettah", 46);

        // 2. Birden çok Category nesnesi oluşturduk
        Category cat1 = new Category(1, "DR", "Drama");
        Category cat2 = new Category(2, "SF", "Science Fiction");

        // 3. Birden çok Movie nesnesi oluşturup ve score'ları ekledik
        ArrayList<Integer> scores1 = new ArrayList<>();
        scores1.add(8);
        scores1.add(9);
        scores1.add(10);
        ArrayList<Person> actors1 = new ArrayList<>();
        actors1.add(actor1);
        actors1.add(actor2);
        Movie movie1 = new Movie(1, "Inception", scores1, 2010, 15, cat1, "movie", actors1, director1);

        ArrayList<Integer> scores2 = new ArrayList<>();
        scores2.add(7);
        scores2.add(8);
        ArrayList<Person> actors2 = new ArrayList<>();
        actors2.add(actor1);
        Movie movie2 = new Movie(2, "Titanic", scores2, 1997, 12, cat1, "movie", actors2, director1);

        // 4. Birden çok Book nesnesi oluşturup ve score'ları ekledik.
        ArrayList<Integer> scores3 = new ArrayList<>();
        scores3.add(9);
        scores3.add(10);
        Book book1 = new Book(1, "1984", scores3, 1949, 20, cat2, "book", writer1, 328);

        // 5. Bir User nesnesi tanımladım.
        User user = new User(1, "Test", "User", "testUser", "123456");

        // 6. Bir Netflix nesnesi oluşturdum.
        ArrayList<Material> materials = new ArrayList<>();
        Netflix netflix = new Netflix(materials);

        // 7. Netflix için oturum açtık
        netflix.login(user);

        // 8. Netflix nesnesine 3 ve 4 maddelerinde oluştuduğunuz nesneleri ekledik.
        netflix.addMovie(movie1);
        netflix.addMovie(movie2);
        netflix.addBook(book1);

        // 9. Netflix bölümünde bahsedilmiş olan N1-N2-N3-N4 fonksiyonlarını netflix nesnesi için çalıştırıp çıktılarının ayrı ayrı görüntülenmesini sağladık.
        System.out.println("En Yüksek Ortalamalı :");
        netflix.showHighestAvgScoreMaterial();

        System.out.println("\nEn düşük Ortalama Puanlı Filmler:");
        netflix.showLowestAvgScoreMovie();

        System.out.println("\n1. Kategorideki En pahali materyal:");
        netflix.showMostExpensiveMaterialInCategory(1);

        System.out.println("\nID'si 1 olan Aktorun filmleri:");
        netflix.showMoviesByActor(1);
    }
}
