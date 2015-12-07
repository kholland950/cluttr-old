package edu.capital.csdb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DB Util class
 */
public class DatabaseUtil {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "admin";
    public static final String DBMS = "mysql";
    public static final String SERVER_NAME = "localhost";
    public static final String DB_NAME = "socialnet";
    public static final String PORT_NUMBER = "3306";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", USERNAME);
        connectionProps.put("password", PASSWORD);

        if (DBMS.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + DBMS + "://" +
                            SERVER_NAME +
                            ":" + PORT_NUMBER + "/",
                    connectionProps);
        } else if (DBMS.equals("derby")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + DBMS + ":" +
                            DB_NAME +
                            ";create=true",
                    connectionProps);
        }
        System.out.println("Connected to database");
        return conn;
    }
}
