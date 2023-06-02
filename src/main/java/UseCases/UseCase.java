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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

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

    public String buildEntry(String fName, String lName, String firm, String idType) {
        db.entryDKinsert(new Entry(fName, lName, firm, idType));
        return "";
    }

    public String loginCheck(String email, String password) throws SQLException {
        String res = db.getPassword(email);
        if (res == "") {
            return "";
        }
        if (res.equals(password)) {
            return "Correct";
        } else {
            return "Wrong password";
        }
    }

    public static void buildListByPeriod() {
        HashMap<Integer, String> accessByPeriod = new HashMap<>();
        db.listAccessByPeriod();
        for (int i = 0; i < accessByPeriod.size(); i++) {
            System.out.println(accessByPeriod.get(i));
        }
    }
    //only supposed to be able when another admin is logged in. method checks if email is already in DB, then adds if false
// method checks if email is identical
    public static void addAdmin(String email, String password) {
        boolean isOccopied;

        String identicalEmail = db.getEmail(email);
        if (identicalEmail != email) {
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
    }
}