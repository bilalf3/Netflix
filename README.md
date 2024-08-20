# **Netflix Projesi Dökümantasyonu**

## **Proje Tanımı**

Bu proje, Film ve Kitapları barındıran bir Netflix kütüphanesi oluşturmayı amaçlar. Kullanıcı, bu kütüphaneye giriş yapabilir ve en iyi film, en pahalı kitap, bir aktörün oynadığı tüm filmler gibi bilgileri görüntüleyebilir.

## **Sınıflar ve Fonksiyonlar**

### **1. Person Sınıfı**
Bu sınıf, bir kişiyi temsil eder.

- **Nitelikler:**
  - `id:int`
  - `firstName:string`
  - `lastName:string`
  - `age:int`

### **2. User Sınıfı**
Bu sınıf, Person sınıfından türemiştir ve bir kullanıcıyı temsil eder.

- **Nitelikler:**
  - `userName:string`
  - `password:string`
  
- **Metotlar:**
  - `User(id,firstName,lastName,userName,password)`

### **3. Category Sınıfı**
Bu sınıf, bir materyalin kategorisini temsil eder.

- **Nitelikler:**
  - `id:int`
  - `categoryCode:string`
  - `categoryName:string`

- **Metotlar:**
  - `Category(id,code,name)`

### **4. Material Sınıfı (Abstract)**
Bu sınıf, film ve kitap gibi materyallerin genel özelliklerini barındırır.

- **Nitelikler:**
  - `id:int`
  - `name:string`
  - `scores:ArrayList<Integer>`
  - `release_year:int`
  - `category:Category`
  - `price:int`
  - `type:string` (movie veya book)
  
- **Metotlar:**
  - `Material(id,name,scores,release_year,price,category,type)`
  - `addScore(int score)`
  - `double getAvgScore()`
  - `abstract void showDetail()`

### **5. Book Sınıfı**
Material sınıfından türemiştir ve kitapları temsil eder.

- **Nitelikler:**
  - `writer:Person`
  - `numberOfPages:int`

- **Metotlar:**
  - `Book(id,name,scores,release_year,price,category,type,writer,numberOfPages)`
  - `setWriter(Person newWriter)`
  - `showDetail()` (Material'dan türetilmiş ve özelleştirilmiş)

### **6. Movie Sınıfı**
Material sınıfından türemiştir ve filmleri temsil eder.

- **Nitelikler:**
  - `actors:ArrayList<Person>`
  - `director:Person`

- **Metotlar:**
  - `Movie(id,name,scores,release_year,price,category,type,actors,director)`
  - `addActor(Person actor)`
  - `showDetail()` (Material'dan türetilmiş ve özelleştirilmiş)

### **7. Netflix Sınıfı**
Bu sınıf, kullanıcıların materyaller üzerinde işlem yapmasını sağlar.

- **Nitelikler:**
  - `materials:ArrayList<Material>`
  - `credential:User`
  - `isLogin:boolean` (Başlangıç değeri false)

- **Metotlar:**
  - `Netflix(ArrayList<Material> materials)`
  - `void login(User user)`
  - `void addMovie(Movie m1)`
  - `void addBook(Book b1)`
  - `void addMaterial(Material m2)`
  - `void showHighestAvgScoreMaterial()`
  - `void showLowestAvgScoreMovie()`
  - `void showMostExpensiveMaterialInCategory(int categoryId)`
  - `void showMoviesByActor(int actorId)`


## Proje Akışı

1. **Birden Çok `Person` Nesnesi Oluşturulması**
   - Örnek kişiler:
     ```java
     Person director = new Person(1, "Steven", "Spielberg", 74);
     Person actor1 = new Person(2, "Leonardo", "DiCaprio", 46);
     Person writer = new Person(3, "George", "Orwell", 47);
     ```

2. **Birden Çok `Category` Nesnesi Oluşturulması**
   - Örnek kategoriler:
     ```java
     Category drama = new Category(1, "D001", "Drama");
     Category fiction = new Category(2, "B001", "Fiction");
     ```

3. **Birden Çok `Movie` Nesnesi Oluşturulması ve Puanların Eklenmesi**
   - Örnek film ve puanlar:
     ```java
     ArrayList<Integer> movieScores = new ArrayList<>(Arrays.asList(9, 8, 10));
     Movie movie1 = new Movie(1, "Inception", movieScores, 2010, 15, drama, "movie", new ArrayList<>(Arrays.asList(actor1)), director);
     movie1.addScore(9);
     ```

4. **Birden Çok `Book` Nesnesi Oluşturulması ve Puanların Eklenmesi**
   - Örnek kitap ve puanlar:
     ```java
     ArrayList<Integer> bookScores = new ArrayList<>(Arrays.asList(8, 7, 9));
     Book book1 = new Book(2, "1984", bookScores, 1949, 20, fiction, "book", writer, 328);
     book1.addScore(8);
     ```

5. **Bir `User` Nesnesi Tanımlanması**
   - Örnek kullanıcı:
     ```java
     User user = new User(1, "John", "Doe", "testUser", "123456");
     ```

6. **Bir `Netflix` Nesnesi Oluşturulması**
   - Netflix nesnesi:
     ```java
     ArrayList<Material> materials = new ArrayList<>();
     Netflix netflix = new Netflix(materials);
     ```

7. **Netflix İçin Oturum Açılması**
   - Kullanıcı oturumu:
     ```java
     netflix.login(user);
     ```

8. **Netflix Nesnesine Film ve Kitapların Eklenmesi**
   - Film ve kitap ekleme:
     ```java
     netflix.addMovie(movie1);
     netflix.addBook(book1);
     ```

9. **Netflix Fonksiyonlarının Çalıştırılması**
   - **En Yüksek Ortalamalı Materyal:**
     ```java
     netflix.showHighestAvgScoreMaterial();
     ```
     Çıktı:
     ```
     Movie: Inception
     Director: Steven Spielberg
     Actors: Leonardo DiCaprio
     Average Score: 9.0
     Price: $15
     ```

   - **En Düşük Ortalamalı Film:**
     ```java
     netflix.showLowestAvgScoreMovie();
     ```
     Çıktı:
     ```
     Movie: Inception
     Director: Steven Spielberg
     Actors: Leonardo DiCaprio
     Average Score: 9.0
     Price: $15
     ```

   - **Belirli Bir Kategorideki En Pahalı Materyal:**
     ```java
     netflix.showMostExpensiveMaterialInCategory(2);
     ```
     Çıktı:
     ```
     Book: 1984
     Writer: George Orwell
     Number of Pages: 328
     Average Score: 8.0
     Price: $20
     ```

   - **Belirli Bir Aktörün Oynadığı Filmler:**
     ```java
     netflix.showMoviesByActor(2);
     ```
     Çıktı:
     ```
     Movie: Inception
     Director: Steven Spielberg
     Actors: Leonardo DiCaprio
     Average Score: 9.0
     Price: $15
     ```

## Sonuç

Bu proje, verilen gereksinimleri karşılamakta ve belirtilen fonksiyonları başarılı bir şekilde çalıştırmaktadır. Stream API kullanılarak yapılan işlemler, kodu daha okunabilir ve verimli hale getirmiştir.

## Lisans

Bu proje [MIT Lisansı](LICENSE) altında lisanslanmıştır.
