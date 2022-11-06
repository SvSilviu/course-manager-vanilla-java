package models;

public class User {

    private int id = 0;
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String password = "";
    private int age = 0;

    private String type = "";

    public User(int id, String firstName, String lastName, String email, String password, int age, String type) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
        this.type = type;
    }

    public User(String text) {

        String[] proprietati = text.split(",");
        this.id = Integer.parseInt(proprietati[0]);
        this.firstName = proprietati[1];
        this.lastName = proprietati[2];
        this.email = proprietati[3];
        this.password = proprietati[4];
        this.age = Integer.parseInt(proprietati[5]);
        this.type = proprietati[6];

    }

    public User() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String descriere() {

        String text = "";

        text += "First Name - " + firstName + "\n";
        text += "Last Name - " + lastName + "\n";
        text += "Age - " + age + "\n";
        text += "Id - " + id + "\n";
        text += "Email - " + email + "\n";
        text += "Password - " + password + "\n";
        text += "Type - " + type + "\n";

        return text;

    }

}
