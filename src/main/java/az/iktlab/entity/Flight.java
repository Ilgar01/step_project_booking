package az.iktlab.entity;



public class Flight {
    private int flightId;
    private String localDate;
    private  String localTime;
    private String destination;
    private int seats;
    private int fullSeats;
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getFullSeats() {
        return fullSeats;
    }

    public void setFullSeats(int fullSeats) {
        this.fullSeats = fullSeats;
    }

    @Override
    public String toString() {
        return "ID: "+getFlightId()+" | DATE: "+getLocalDate()+" | TIME: "+getLocalTime()+
                " | DESTINATION: "+getDestination()+" | SEATS: "+getSeats()+" | FULL SEATS: "+getFullSeats();
    }
}
