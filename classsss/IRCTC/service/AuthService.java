package service;

import util.*;
import java.sql.*;

public class AuthService {

    public void register(String name, String email, String password) throws Exception {
        

        String hashed = HashUtil.hashPassword(password);

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO users(name,email,password) VALUES(?,?,?)"
        );

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, hashed);

        ps.executeUpdate();
        System.out.println("User Registered!");
        
    }
          
    public int login(String email, String password) throws Exception {

        String hashed = HashUtil.hashPassword(password);

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT user_id FROM users WHERE email=? AND password=?"
        );

        ps.setString(1, email);
        ps.setString(2, hashed);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("user_id");
        }
        
        
        
        

        return -1;
    }
    
    
}
