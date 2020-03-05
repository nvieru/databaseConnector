package demo.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;

    public static final String TABLE_NAME = "USERS";

    public static final String FIELD_ID = "ID";
    public static final String FIELD_FIRST_NAME = "FIRST_NAME";
    public static final String FIELD_LAST_NAME = "LAST_NAME";

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "id: " + id + " first name: " + firstName + " last name: " + lastName;
    }
}
