package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
        public static Connection getConnection() throws SQLException, ClassNotFoundException {
            Connection connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee";
            String user = "root";
            String pass = "admin";
            connection = DriverManager.getConnection(url, user, pass);
            return connection;
        }
}
