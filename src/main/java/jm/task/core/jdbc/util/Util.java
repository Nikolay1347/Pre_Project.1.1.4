package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/preproject.1.1.3";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "admin";



    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        return connection;
    }
}
