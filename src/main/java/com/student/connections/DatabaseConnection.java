package com.student.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 11/09/20 5:34 PM
 */
public class DatabaseConnection {

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1@1rpt211";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/LEARN?verifyServerCertificate=false&useSSL=true";


    /**
     * Creates the required database connection
     * @return Database connection instance
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
    }
}
