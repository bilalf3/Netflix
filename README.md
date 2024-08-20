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

