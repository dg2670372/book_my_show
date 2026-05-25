package service;

import util.*;

import java.sql.*;
import java.util.Random;

public class BookingService {

    public synchronized void bookTicket(int userId, int trainId) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT available_seats FROM trains WHERE train_id=?"
            );
            ps.setInt(1, trainId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int seats = rs.getInt("available_seats");

                if (seats > 0) {

                    PreparedStatement update = con.prepareStatement(
                        "UPDATE trains SET available_seats=available_seats-1 WHERE train_id=?"
                    );
                    update.setInt(1, trainId);
                    update.executeUpdate();

                    String pnr = String.valueOf(new Random().nextInt(999999999));

                    PreparedStatement insert = con.prepareStatement(
                        "INSERT INTO tickets VALUES(?,?,?,?,?)"
                    );

                    insert.setString(1, pnr);
                    insert.setInt(2, userId);
                    insert.setInt(3, trainId);
                    insert.setInt(4, seats);
                    insert.setString(5, "CONFIRMED");

                    insert.executeUpdate();

                    con.commit();
                    System.out.println("Booked! PNR: " + pnr);

                } else {
                    throw new RuntimeException("No seats available");
                }
            }

        } catch (Exception e) {
            con.rollback();
            throw e;
        }
       
    }
}