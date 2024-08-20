package netflix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Netflix {
    ArrayList<Material> materials;
    User credential;
    boolean isLogin = false;

    public Netflix(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public void login(User user) {
        if ("testUser".equals(user.userName) && "123456".equals(user.password)) {
            this.isLogin = true;
            this.credential = user;
        }
    }

    public void addMovie(Movie m1) {
        if (isLogin) {
            this.materials.add(m1);
        }
    }

    public void addBook(Book b1) {
        if (isLogin) {
            this.materials.add(b1);
        }
    }

    public void addMaterial(Material m2) {
        if (isLogin) {
            this.materials.add(m2);
        }
    }

    // En yüksek ortalama skora sahip materyali bulma
    public void showHighestAvgScoreMaterial() {
        materials.stream()
                .max(Comparator.comparingDouble(Material::getAvgScore))
                .ifPresent(Material::showDetail);
    }

    // En düşük ortalama skorlu filmi bulma
    public void showLowestAvgScoreMovie() {
        materials.stream()
                .filter(material -> material instanceof Movie)
                .min(Comparator.comparingDouble(Material::getAvgScore))
                .ifPresent(Material::showDetail);
    }

    // Belirli bir kategoriye ait en pahalı materyali bulma
    public void showMostExpensiveMaterialInCategory(int categoryId) {
        materials.stream()
                .filter(material -> material.category.id == categoryId)
                .max(Comparator.comparingInt(material -> material.price))
                .ifPresent(Material::showDetail);
    }

    // Belirli bir aktörün oynadığı filmleri  bulma
    public void showMoviesByActor(int actorId) {
        materials.stream()
                .filter(material -> material instanceof Movie)
                .map(material -> (Movie) material)
                .filter(movie -> movie.actors.stream().anyMatch(actor -> actor.id == actorId))
                .forEach(Movie::showDetail);
    }
}
