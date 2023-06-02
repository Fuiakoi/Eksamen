package Entities;

import java.time.LocalDateTime;

public class Entry {

    String fName;
    String lName;
    String idType;
    String firm;
    LocalDateTime time;

    public Entry(String fName, String lName, String firm, String idType) {
        this.fName = fName;
        this.lName = lName;
        this.firm = firm;
        this.idType = idType;
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

    @Override
    public String toString() {
        return "Entry{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", firm='" + firm + '\'' +
                ", idType='" + idType + '\'' +
                /*", now=" + now +*/
                '}';
    }
}