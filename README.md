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
     Person actor1 = new Person(1, "Bilal ", "Fettahlioglu", 45);
     Person actor2 = new Person(2, "Test", "Kisisi", 56);
     Person director1 = new Person(3, "BYapimci", "Tarantino", 57);
     Person writer1 = new Person(4, "Byazar", "Fettah", 46);
     ```

2. **Birden Çok `Category` Nesnesi Oluşturulması**
   - Örnek kategoriler:
     ```java
     Category cat1 = new Category(1, "DR", "Drama");
     Category cat2 = new Category(2, "SF", "Science Fiction");
     ```

3. **Birden Çok `Movie` Nesnesi Oluşturulması ve Puanların Eklenmesi**
   - Örnek film ve puanlar:
     ```java
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
     ```

4. **Birden Çok `Book` Nesnesi Oluşturulması ve Puanların Eklenmesi**
   - Örnek kitap ve puanlar:
     ```java
     ArrayList<Integer> scores3 = new ArrayList<>();
     Book book1 = new Book(1, "1984", scores3, 1949, 20, cat2, "book", writer1, 328);
     scores3.add(9);
     scores3.add(10);
     
     ```

5. **Bir `User` Nesnesi Tanımlanması**
   - Örnek kullanıcı:
     ```java
     User user = new User(1, "Test", "User", "testUser", "123456");
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
     Kitap: 1984
     Yazar: Byazar Fettah
     Sayfa Sayisi: 328
     Ortalama Skor: 9.5
     Fiyat: ₺20
     ```

   - **En Düşük Ortalamalı Film:**
     ```java
     netflix.showLowestAvgScoreMovie();
     ```
     Çıktı:
     ```
     Film: Titanic
     Yapimci: BYapimci Tarantino
     Aktor: Bilal  Fettahlioglu
     Ortalama Skor: 7.5
     Fiyat: ₺12
     ```

   - **Belirli Bir Kategorideki En Pahalı Materyal:**
     ```java
     netflix.showMostExpensiveMaterialInCategory(1);
     ```
     Çıktı:
     ```
     Film: Inception
     Yapimci: BYapimci Tarantino
     Aktor: Bilal  Fettahlioglu
     Ortalama Skor: 9.0
     Fiyat: ₺15
     ```

   - **Belirli Bir Aktörün Oynadığı Filmler:**
     ```java
     netflix.showMoviesByActor(1);
     ```
     Çıktı:
     ```
     Film: Titanic
     Yapimci: BYapimci Tarantino
     Aktor: Bilal Fettahlioglu
     Ortalama Skor: 7.5
     Fiyat: ₺12
     ```



