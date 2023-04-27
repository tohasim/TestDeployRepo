package com.example.test.Repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class DBManager {
    private static Connection con = null;

    private static String URL, USER, PASSWORD;

    @Value("${spring.datasource.url}")
    public void setURL(String url){
        URL = url;
    }

    @Value("${spring.datasource.user}")
    public void setUSER(String user){
        USER = user;
    }
    
    @Value("${spring.datasource.password}")
    public void setPASSWORD(String password){
        PASSWORD = password;
    }
    public static Connection getConnection(){
        if (con != null) return con;
        try{
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
