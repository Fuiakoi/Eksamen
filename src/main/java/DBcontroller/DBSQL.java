package DBcontroller;

import Entities.Admin;
import Entities.Entry;
import Entities.Firm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSQL {
    private static Connection connection;
    private Statement stmt;
    private Statement stmt1;
    public static String realUrl = "jdbc:sqlite:C://Users/aikke/Desktop/Eksamen/udviddet.db";
//C://Users/mostg/OneDrive/Skrivebord/Eksamen/udviddet.db
    public DBSQL(){
        String url = realUrl;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void entryDKinsert(Entry entry) {
        try {
            String sql = "INSERT INTO entry (fName, lName, firm, idType/*, pictureID*/, time) " +
                    "VALUES ('" + entry.getfName() + "','" + entry.getlName() + "','" + entry.getFirm() + "','" + entry.getIdType() + "','" + entry.getDateTime()
                    + /*entry.getPictureID() + */"')";
                    openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // closeConnection();
    }

    public static void openConnection() {
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

    public static List<Entry> listAccessByPeriod() {
        List<Entry> entries = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Entry";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Entry entry = new Entry();
                entry.setfName(rs.getString("fName"));
                entry.setlName(rs.getString("lName"));
                entry.setFirm(rs.getString("firm"));
                entry.setIdType(rs.getString("idType"));
                entry.setLocalTime(rs.getString("time"));
                // entry.setDateTime(LocalDateTime.parse(rs.getString("time")));
                entries.add(entry);
            }
            stmt.close();
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return entries;
    }

    /*public void listAccessByPeriod() {
        try {
            String sql = "SELECT * FROM Entry";
            openConnection();
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
    }*/

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

    public  String getAdminPassword(String email) {
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

    public  String getUserPassword(String email) {
        try {
            String sql = "SELECT password FROM User WHERE email = '" + email + "'";
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

    public static void firmInsert(String firm) {
        try {
            String sql = "INSERT INTO Firm (firmName) " +
                    "VALUES ('" + firm + "')";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // closeConnection();
    }


    /*public String getAdminEmail(String email) {
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
    }*/

    /*public static String checkEmail(User user) {
        try {
            String sql = "SELECT email FROM User WHERE email = '" + user.getEmail() + "'";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                String userExists = rs.getString("");
                stmt.close();
                closeConnection();
                return "UserExists";
            } else {
                insertUser(user);
                return "User created";
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
        return "";
    }*/

    /*public static void insertUser(User user) {
        try {
            String sql = "INSERT INTO User (email, password) VALUES ('" + user.getEmail() + "','" + user.getPassword() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    /*public static List<String> dropdownFirms() {
        List<String> firmList = new ArrayList<>();
        try {
            String sql = "SELECT firmName FROM Firm";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                String firmName = rs.getString("firmName");
                System.out.println("Found firm name: " + firmName);  // Print each firm name
                firmList.add(firmName);
            }
            stmt.close();
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Final firm list: " + firmList);  // Print the final firm list
        return firmList;
    }*/


    public static List<String> dropdownFirms() {
        List<String> firmList = new ArrayList<>();
        try {
            String sql = "SELECT firmName FROM Firm";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                firmList.add(rs.getString("firmName"));
            }
            stmt.close();
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return firmList;
    }
}