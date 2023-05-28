package DBcontroller;

import Entities.Admin;
import Entities.Entry;
import java.sql.*;

public class DBSQL {
    private static Connection connection;
    private Statement stmt;
    private Statement stmt1;


 /*   public DBSQL() throws SQLException {
        connection = null;
        try {
            String url = "jdbc:sqlite:C://Users/aikke/IdeaProjects/Eksamen/RegisterSQLite.db";
            connection = DriverManager.getConnection(url);
           // connection.isReadOnly();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        }*/
    //}
    public static Connection connectToDatabase(){
        String url = "jdbc:sqlite:C://Users/aikke/IdeaProjects/Eksamen/RegisterSQLite.db";;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void entryDK(Entry entry) { //todo copypaste til amerikansk, find ud af afgrænsning
        System.out.println("1");
        try {
            String sql = "INSERT INTO entry (fName, lName, firm, idType, time) " +
                    "VALUES ('" + entry.getfName() + "','" + entry.getlName() + "','" + entry.getFirm() + "','" + entry.getIdType() + "','" + entry.getNow()
                    + "')";
            //guestID, fName, lName, firm, idType, time, IDpicture?
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("2");
            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
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
        connectToDatabase();
        try {
            String sql = "SELECT * FROM Entry";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("fName") + " " + rs.getString("lName") + " " + rs.getString("firm") + " " + rs.getString("idType") + " " + rs.getString("time"));
            }
            stmt.close();
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteBasedOnAge() {
        try {
            String sql = "SELECT * FROM Entry WHERE datetime(time) < datetime('now', '-3 years')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static Admin getAdmin(String email) throws SQLException{
        connectToDatabase();
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
        connectToDatabase();
        try {
            String sql = "SELECT password FROM Admin WHERE email = '" + email + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            String password = rs.getString("password");
            stmt.close();
            closeConnection();
            return password;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
        return null;
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