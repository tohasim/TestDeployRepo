package com.example.test.Repo;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("TestRepo")
public class Repo {
    public List<String> getAllMessages(){
        List<String> messages = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT message FROM TESTTABLE";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                messages.add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }
}
