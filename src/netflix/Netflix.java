package netflix;

import java.util.ArrayList;

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

    public void showHighestAvgScoreMaterial() {
        Material maxMaterial = null;
        for (Material material : materials) {
            if (maxMaterial == null || material.getAvgScore() > maxMaterial.getAvgScore()) {
                maxMaterial = material;
            }
        }
        if (maxMaterial != null) {
            maxMaterial.showDetail();
        }
    }

    public void showLowestAvgScoreMovie() {
        Movie minMovie = null;
        for (Material material : materials) {
            if (material instanceof Movie) {
                Movie movie = (Movie) material;
                if (minMovie == null || movie.getAvgScore() < minMovie.getAvgScore()) {
                    minMovie = movie;
                }
            }
        }
        if (minMovie != null) {
            minMovie.showDetail();
        }
    }

    public void showMostExpensiveMaterialInCategory(int categoryId) {
        Material expensiveMaterial = null;
        for (Material material : materials) {
            if (material.category.id == categoryId) {
                if (expensiveMaterial == null || material.price > expensiveMaterial.price) {
                    expensiveMaterial = material;
                }
            }
        }
        if (expensiveMaterial != null) {
            expensiveMaterial.showDetail();
        }
    }

    public void showMoviesByActor(int actorId) {
        for (Material material : materials) {
            if (material instanceof Movie) {
                Movie movie = (Movie) material;
                for (Person actor : movie.actors) {
                    if (actor.id == actorId) {
                        movie.showDetail();
                    }
                }
            }
        }
    }
}
