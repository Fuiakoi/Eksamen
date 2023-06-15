package UseCases;

import DBcontroller.DBSQL;
import Entities.Entry;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UseCase {

    static DBSQL db = new DBSQL();

    //  private static Connection connection;
    //private static Statement stmt;

    /*static {
        try {
            db = new DBSQL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public String buildEntry(String fName, String lName, String firm, String idType/*, String pictureID*/) {
        db.entryDKinsert(new Entry(fName, lName, firm, idType/*, pictureID*/));
        return "";
    }

    public String adminLoginCheck(String email, String password) throws SQLException {
        String res = db.getAdminPassword(email);
        if (res == "") {
            return "";
        }
        if (res.equals(password)) {
            return "Correct";
        } else {
            return "Wrong password";
        }
    }

    public String userLoginCheck(String email, String password) throws SQLException {
        String res = db.getUserPassword(email);
        if (res == "") {
            return "";
        }
        if (res.equals(password)) {
            return "Correct";
        } else {
            return "Wrong password";
        }

    }

    //only supposed to be able when another admin is logged in. method checks if email is already in DB, then adds if false
// method checks if email is identical
    /*public static void addAdmin(String email, String password) {
        boolean isOccopied;

        String identicalEmail = db.getAdminEmail(email);
        if (identicalEmail != email) {
            Admin admin = new Admin();
            admin.setEmail(email);
            admin.setPassword(password);
            System.out.println("yay");
        }
        else{
            System.out.println("nay");
        }
    }*/

    //only supposed to be able, when another admin is logged in.
    public static void deleteAdmin() {

    }

    //this method is to use the dbsql deleteBasedOnAge, but do it after some time has passed
    public static void deleteOnTime() {
    }

    /*public static ArrayList<Entry> buildHTMLTableByPeriod() {
        ArrayList<Entry> accessByPeriod = new ArrayList<>();

        *//*return htmlTable.toString();*//*
        return accessByPeriod;
    }*/

    /*public static List<Entry> buildListByPeriod() {
        List<Entry> accessByPeriod = new ArrayList<>();

        // Retrieve data from the database using the listAccessByPeriod() method
        List<Entry> entries = listAccessByPeriod();

        // Add the retrieved entries to the accessByPeriod list
        accessByPeriod.addAll(entries);

        *//*LocalDateTime dateTime = LocalDateTime.parse(Entry.getDateTimeAsString());
        Entry.setDateTime(dateTime);*//*

        return accessByPeriod;
    }*/

    /*public static String buildUser(String email, String password) {
        String res = db.checkEmail(email);
        if (res.equals("User already exists")) {
            return "User exists";
        }
        else {
            return "Usermade";
        }
    }*/

    /*public String userLoginCheck(String email, String password) throws SQLException {
        String res = db.getUserPassword(email);
        if (res == "") {
            return "";
        }
        if (res.equals(password)) {
            return "Correct";
        } else {
            return "Wrong password";
        }
    }*/

    /*public String makeUserCheck(String email, String password) throws SQLException {
        User user = new User(email, password);
        String res = db.checkEmail(user.getEmail());
        if (res == "") {
            return "userExists";
        } else {
            return "userMade";
        }
    }*/
}