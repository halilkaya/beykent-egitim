package net.halilkaya.beykentandroid;

public class UserModel {

    private int id;
    private int photo;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isSubscribed;

    public UserModel() {
    }

    public UserModel(int id, int photo, String firstName, String lastName, String email, boolean isSubscribed) {
        this.id = id;
        this.photo = photo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isSubscribed = isSubscribed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
