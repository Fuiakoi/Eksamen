package Entities;

import java.time.LocalDateTime;

public class Entry {

    String fName;
    String lName;
    String idType;
    String firm;
    LocalDateTime now;


    public Entry(String fName, String lName, String idType, String firm, LocalDateTime now) {
        this.fName = fName;
        this.lName = lName;
        this.idType = idType;
        this.firm = firm;
        this.now = now;
    }

    public Entry() {
    }

    public LocalDateTime getNow() {
        now = LocalDateTime.now().withNano(0);
        return now;
    }
    public void setDateTime(LocalDateTime now) {

        this.now = now;
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

    public LocalDateTime getEntryDateTime() {
        return now;
    }



    @Override
    public String toString() {
        return "Entry{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", idType='" + idType + '\'' +
                ", firm='" + firm + '\'' +
                ", now=" + now +
                '}';
    }
}