package UseCases;

import DBcontroller.DBSQL;
import Entities.Entry;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static DBcontroller.DBSQL.firmInsert;

@Service
public class UseCase {

    static DBSQL db = new DBSQL();

    public static List<String> getFirmNames() {
        List<String> firmNames = DBSQL.dropdownFirms();
        return firmNames;
    }

    public String buildEntry(String fName, String lName, String firm, String idType) {
        db.entryDKinsert(new Entry(fName, lName, firm, idType));
        return "";
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

    public String buildUser(String email, String password) {
        String res = db.checkUser(email);
        if (res.equals("Clear")) {
            db.addUser(email, password);
            System.out.println("User made");
            System.out.println(email);
            return "User made";
        } else {
            System.out.println("Email already taken");
            System.out.println(email);
            return "Email already taken";
        }
    }

    public static String insertFirm(String firmName){
        firmInsert(firmName);
        return firmName;
    }
}