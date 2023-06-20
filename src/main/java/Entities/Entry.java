package Entities;

import java.time.LocalDateTime;

public class Entry {

    String fName;
    String lName;
    String firm;
    String idType;
    String location;
    LocalDateTime time; // Læg tid og dato ind i databasen
    String localTime; // Tag tid og dato ud af databasen

    public Entry() {
    }

    public Entry(String fName, String lName, String firm, String idType) {
        this.fName = fName;
        this.lName = lName;
        this.firm = firm;
        this.idType = idType;
    }

    public Entry(String fName, String lName, String firm, String idType, String localTime) {
        this.fName = fName;
        this.lName = lName;
        this.firm = firm;
        this.idType = idType;
        this.localTime = localTime;
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

    public LocalDateTime getDateTime() {
        time = LocalDateTime.now();
        return time;
    }

    public void setDateTime(LocalDateTime time) {

        this.time = time;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", firm='" + firm + '\'' +
                ", idType='" + idType + '\'' +
                ", time=" + time +
                '}';
    }
}