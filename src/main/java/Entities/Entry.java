package Entities;

import java.time.LocalDateTime;

public class Entry {

    String fName;
    String lName;
    String firm;
    String idType;
    String pictureID;
    String location;
    LocalDateTime time;
    String localTime;

    public Entry(String fName, String lName, String firm, String idType/*, String pictureID*/) {
        this.fName = fName;
        this.lName = lName;
        this.firm = firm;
        this.idType = idType;
        this.pictureID = pictureID;
    }

    public Entry(String fName, String lName, String firm, String idType, String localTime) {
        this.fName = fName;
        this.lName = lName;
        this.firm = firm;
        this.idType = idType;
        this.localTime = localTime;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public Entry() {
    }

    public LocalDateTime getDateTime() {
        time = LocalDateTime.now();
        return time;
    }

    public void setDateTime(LocalDateTime time) {

        this.time = time;
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

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getPictureID() {
        return pictureID;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", idType='" + idType + '\'' +
                ", id='" + pictureID + '\'' +
                ", firm='" + firm + '\'' +
                ", time=" + time +
                '}';
    }
}