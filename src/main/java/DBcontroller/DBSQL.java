package DBcontroller;

import java.sql.*;

public class DBSQL {
    private static Connection connection;
    private Statement stmt;
    private Statement stmt1;

    public DBSQL() throws SQLException {
        connection = null;
        try {
            String url = "jdbc:sqlite:C://Users/mostg/OneDrive/Skrivebord/RegisterIntec/RegisterSQLite.db";
            connection = DriverManager.getConnection(url);
            connection.isReadOnly();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        }
    }
    /*public void entryDK(Entry entry) { //todo copypaste til amerikansk, find ud af afgrænsning
        System.out.println("1");
        try {
            String sql = "INSERT INTO Entry (fName, lName, firm, idType, time) " +
                    "VALUES ('" + entry.getfName() + "','" + entry.getlName()+ "','" + entry.getFirm() + "','" + entry.getIdType() + "','" + entry.getNow()
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
    }*/

    private void closeConnection() {
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
                System.out.println(rs.getString("fName") + " " + rs.getString("lName") + " " + rs.getString("firm") + " " + rs.getString("idType") + " " + rs.getString("time"));
            }
            stmt.close();
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
    public static String getPassword(String email) {
        try {
            String sql = "SELECT password FROM User WHERE email = '" + email + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            String password = rs.getString("password");
            stmt.close();
            return password;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}