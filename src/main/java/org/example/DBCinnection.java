package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCinnection {
    private String URL = "jdbc:postgresql://localhost:5432";
    private String DB_NAME = "exam_products";
    private String USER = "postgres";
    private String PASSWORD = "30.03.2009";

    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL + "/" + DB_NAME, USER, PASSWORD);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
