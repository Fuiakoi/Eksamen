package UseCases;

import DBcontroller.DBSQL;
import Entities.Entry;
import java.sql.SQLException;
import DBcontroller.DBSQL;
import Entities.Entry;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class UseCase {

    static DBSQL db;

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

    public static void buildListByPeriod() {
        HashMap<Integer, String> accessByPeriod = new HashMap<>();
        db.listAccessByPeriod();
        for (int i = 0; i < accessByPeriod.size(); i++) {
            System.out.println(accessByPeriod.get(i));
        }
    }
    public static String loginCheck(String email, String password) throws SQLException {
        db = new DBSQL();
        String res = db.getPassword(email);
        if (res.equals(null))
            return "Wrong email";
        if (res.equals(password)) {
            return "Correct";
        } else {
            return "Wrong password";
        }
    }
}