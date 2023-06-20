package Entities;

public class Firm {
    private String firmName;



    public Firm() {
    }

    public Firm(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "firmName='" + firmName + '\'' +
                '}';
    }
}