package DBcontroller;

import Entities.Admin;
import Entities.Entry;
import org.springframework.cglib.core.Local;
import java.sql.*;
import java.time.LocalDateTime;

public class DBSQL {
    private static Connection connection;
    private Statement stmt;
    private Statement stmt1;
    public String realUrl = "jdbc:sqlite:C://Users/aikke/Desktop/Eksamen/RegisterSQLite.db";
//C://Users/mostg/OneDrive/Skrivebord/Eksamen/RegisterSQLite.db
    public DBSQL(){
        String url = realUrl;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void entryDKinsert(Entry entry) { //todo copypaste til amerikansk, find ud af afgrænsning
        try {
            String sql = "INSERT INTO entry (fName, lName, firm, idType, time) " +
                    "VALUES ('" + entry.getfName() + "','" + entry.getlName() + "','" + entry.getFirm() + "','" + entry.getIdType() + "','" + entry.getDateTime()
                    + "')";
            // String sql = "INSERT INTO entry (fName, lName, firm, idType) VALUES ('Sofia', 'Mostgaard', 'IBM', 'Pas')";
            //guestID, fName, lName, firm, idType, time, IDpicture?
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // closeConnection();
    }

    public void openConnection() {
        String url = realUrl;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//access til print funktioner //todo efter html implementering

    public void listAccessByPeriod() {
        try {
            String sql = "SELECT * FROM Entry";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("fName") + " " + rs.getString("lName") + " "
                        + rs.getString("firm") + " " + rs.getString("idType") + " "
                        + rs.getString("time"));
            }
            stmt.close();
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteBasedOnAge() {
        try {
            String sql = "DELETE FROM Entry WHERE datetime(time) < datetime('now', '-3 years')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static Admin getAdmin(String email) throws SQLException{
        Admin admin = null;
        String sql = "SELECT email, password FROM Admin WHERE email = '" + email + "'";
        Statement stmt = connection.createStatement();

        try (ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                admin = new Admin();
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
            }
        }
        closeConnection();
        return admin;
    }

    public  String getPassword(String email) {
        try {
            String sql = "SELECT password FROM Admin WHERE email = '" + email + "'";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                String password = rs.getString("password");
                stmt.close();
                closeConnection();
                return password;
            }
            return "";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
        return "";
    }

    public String getEmail(String email) {
        String hov;
        try {
            String sql = "SELECT email FROM Admin WHERE email = '" + email + "'";
            Statement stmt = connection.createStatement();

            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            hov = rs.getString(1);
            System.out.println(hov);
            stmt.close();
            return hov;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}