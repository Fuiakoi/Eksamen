package DBcontroller;

import Entities.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSQL {
    private static Connection connection;
    private Statement stmt;
    private Statement stmt1;
    public static String realUrl = "jdbc:sqlite:C://Users/aikke/Desktop/Eksamen/udviddet.db";
     /*"jdbc:sqlite:C://Users/mostg/OneDrive/Skrivebord/Eksamen/udviddet.db";*/
    public DBSQL(){
        String url = realUrl;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public static void entryDKinsert(Entry entry) {
        try {
            String sql = "INSERT INTO entry (fName, lName, firm, idType, time) " +
                    "VALUES ('" + entry.getfName() + "','"
                    + entry.getlName() + "','" + entry.getFirm()
                    + "','" + entry.getIdType() + "','" + entry.getDateTime()
                    + "')";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
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

    public String checkUser(String email) {
        try {
            String sql = "SELECT * FROM User WHERE email = '" + email + "'";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                System.out.println("checkuser - Taken");
                System.out.println(email);
                stmt.close();
                closeConnection();
                return "Taken";
            } else {
                System.out.println("checkuser - Clear");
                System.out.println(email);
                stmt.close();
                closeConnection();
                return "Clear";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(String email, String password) {
        try {
            String sql = "INSERT INTO User (email, password) " +
                    "VALUES ('" + email + "','" + password + "')";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String checkAdmin(String email) {
        try {
            String sql = "SELECT * FROM Admin WHERE email = '" + email + "'";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                System.out.println("checkadmin - Taken");
                System.out.println(email);
                stmt.close();
                closeConnection();
                return "Taken";
            } else {
                System.out.println("checkadmin - Clear");
                System.out.println(email);
                stmt.close();
                closeConnection();
                return "Clear";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAdmin(String email, String password) {
        try {
            String sql = "INSERT INTO Admin (email, password) " +
                    "VALUES ('" + email + "','" + password + "')";
            openConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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
                entries.add(entry);
            }
            stmt.close();
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return entries;
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
        closeConnection();
    }
    public static void userDelete(String email){
        System.out.println("DB call 1");
        try {
            String sql = "DELETE FROM User WHERE email = '" + email + "'";
            openConnection();
            Statement stmt = connection.createStatement();
            System.out.println("stmt next 1");
            stmt.execute(sql);
            System.out.println("stmt done");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

