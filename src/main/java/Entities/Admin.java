package Entities;

public class Admin {
private String email;
private String password;
private Boolean isLoggedIn;

    public Admin() {
    }

    public Admin(String email, String password, Boolean isLoggedIn) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}