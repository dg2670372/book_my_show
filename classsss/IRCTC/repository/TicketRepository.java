package repository;
import model.Ticket;
import util.DBConnection;

import java.sql.*;

public class TicketRepository {

    public void saveTicket(Ticket ticket) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "INSERT INTO tickets VALUES(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, ticket.getPnr());
        ps.setInt(2, ticket.getUserId());
        ps.setInt(3, ticket.getTrainId());
        ps.setInt(4, ticket.getSeatNumber());
        ps.setString(5, ticket.getStatus());

        ps.executeUpdate();
    }

    public Ticket findByPNR(String pnr) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM tickets WHERE pnr=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, pnr);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Ticket(
                rs.getString("pnr"),
                rs.getInt("user_id"),
                rs.getInt("train_id"),
                rs.getInt("seat_number"),
                rs.getString("status")
            );
        }

        return null;
    }

    public void deleteTicket(String pnr) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "DELETE FROM tickets WHERE pnr=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, pnr);

        ps.executeUpdate();
    }
}
