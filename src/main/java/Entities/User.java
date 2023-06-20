package Entities;

public class User {
    private String email;
    private String password;
    private String fName;
    private String lName;
    private String firm;
    private String idType;
    private String pictureID;
    private String location;

    public User(String email, String password, String fName, String lName, String firm, String idType, String pictureID,
                String location) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.firm = firm;
        this.idType = idType;
        this.pictureID = pictureID;
        this.location = location;
    }

    public User(String email, String password) {
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getPictureID() {
        return pictureID;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", firm='" + firm + '\'' +
                ", idType='" + idType + '\'' +
                ", pictureID='" + pictureID + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}