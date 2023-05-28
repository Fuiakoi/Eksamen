package UseCases;

import DBcontroller.DBSQL;
import Entities.Admin;
import Entities.Entry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.HashMap;

public class UseCase {

    static DBSQL db;
    private static Connection connection;
    //private static Statement stmt;

    /*static {
        try {
            db = new DBSQL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public void buildEntry(String fName, String lName, String firm, String idType, LocalDateTime now) {
        db.entryDK(new Entry(fName, lName, firm, idType, now));
    }

    public static Admin getEmail(String email) throws SQLException{
        System.out.println("Fetching admin with email: " + email);
        Admin admin = null;
        String sql = "SELECT email, password FROM Admin WHERE email = '" + email + "'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                admin = new Admin();
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                System.out.println("Found admin with email: " + rs.getString("email"));
            }
        }

        return admin;
    }



    /*public static String loginCheck(String email, String password) throws SQLException {
        db = new DBSQL();
        String res = db.getPassword(email);
        if (res.equals(null))
            return "Wrong email";
        if (res.equals(password)) {
            return "Correct";
        } else {
            return "Wrong password";
        }
    }*/

    public static void buildListByPeriod() {
        HashMap<Integer, String> accessByPeriod = new HashMap<>();
        db.listAccessByPeriod();
        for (int i = 0; i < accessByPeriod.size(); i++) {
            System.out.println(accessByPeriod.get(i));
        }
    }
    //only supposed to be able when another admin is logged in. method checks if email is already in DB, then adds if false
/*    public static void addAdmin(String email, String password) {
boolean isOccopied;

        String hov = db.getEmail(email);
        if (hov == email) {
            Admin admin = new Admin();
            admin.setEmail(email);
            admin.setPassword(password);
            System.out.println("yay");
        }
        else{
            System.out.println("nay");
        }
    }
    //only supposed to be able, when another admin is logged in.
    public static void deleteAdmin(){

    }
    //this method is to use the dbsql deleteBasedOnAge, but do it after some time has passed
    public static void deleteOnTime(){

    }*/
}