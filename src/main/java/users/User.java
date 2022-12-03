package users;

public class User {
    private final int id;
    private final String name;

    public User(int userId, String userName) {
        id = userId;
        name = userName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
