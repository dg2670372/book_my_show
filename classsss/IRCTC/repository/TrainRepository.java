package repository;


import model.Train;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class TrainRepository {

    public void addTrain(Train train) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "INSERT INTO trains(train_name,source,destination,total_seats,available_seats) VALUES(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, train.getTrainName());
        ps.setString(2, train.getSource());
        ps.setString(3, train.getDestination());
        ps.setInt(4, train.getTotalSeats());
        ps.setInt(5, train.getAvailableSeats());

        ps.executeUpdate();
    }

    public List<Train> searchTrains(String source, String destination) throws Exception {

        List<Train> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM trains WHERE source=? AND destination=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, source);
        ps.setString(2, destination);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Train t = new Train(
                rs.getInt("train_id"),
                rs.getString("train_name"),
                rs.getString("source"),
                rs.getString("destination"),
                rs.getInt("total_seats"),
                rs.getInt("available_seats")
            );
            list.add(t);
        }

        return list;
    }

    public int getAvailableSeats(int trainId) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "SELECT available_seats FROM trains WHERE train_id=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, trainId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("available_seats");
        }

        return 0;
    }

    public void updateSeats(int trainId, int seats) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "UPDATE trains SET available_seats=? WHERE train_id=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, seats);
        ps.setInt(2, trainId);

        ps.executeUpdate();
    }
}