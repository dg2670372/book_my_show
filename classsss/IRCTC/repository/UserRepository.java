package repository;


import java.sql.*;

import model.User;
import util.DBConnection;



public class UserRepository {

    public void saveUser(User user) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "INSERT INTO users(name,email,password) VALUES(?,?,?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
    }

    public User findByEmailAndPassword(String email, String password) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM users WHERE email=? AND password=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new User(
                rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password")
            );
        }

        return null;
    }
}