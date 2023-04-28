package com.example.test.Repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBManager {
    private static Connection con = null;
    private static String url, user, password;

    @Value("${spring.datasource.url}")
    public void setUrl(String url) {
        DBManager.url = url;
    }

    @Value("${spring.datasource.username}")
    public void setUser(String user) {
        DBManager.user = user;
    }

    @Value("${spring.datasource.password}")
    public void setPassword(String password) {
        DBManager.password = password;
    }

    public static Connection getConnection() {
        if (con != null) return con;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
