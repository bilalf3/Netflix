package netflix;

public class User extends Person {
    String userName;
    String  password;

    public User(int id, String firstName, String lastName, String userName, String password) {
        super(id, firstName, lastName, 0); 
        this.userName = userName;
        this.password = password;
    }
}
