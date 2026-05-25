package model;



public class Ticket {

    private String pnr;
    private int userId;
    private int trainId;
    private int seatNumber;
    private String status;

    public Ticket() {}

    public Ticket(String pnr, int userId, int trainId, int seatNumber, String status) {
        this.pnr = pnr;
        this.userId = userId;
        this.trainId = trainId;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}