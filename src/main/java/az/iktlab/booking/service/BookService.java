package az.iktlab.booking.service;

import az.iktlab.booking.dao.BookDao;
import az.iktlab.entity.Flight;
import az.iktlab.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BookService {
    BookDao bookdao = new BookDao();
    public ArrayList<Flight> search(Flight flight, int numberPeople) {
        ResultSet rs = bookdao.search(flight,numberPeople);
        return selectFlights(rs);
    }
    public int[] book(Person[] persons, int flightId){
            return  bookdao.book(persons,flightId);
    }
    public boolean cancel(int bookId){
        if(bookdao.cancel(bookId)==1){
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Flight> myFlights(Person person)  {
       ResultSet rs = bookdao.myFlights(person);
        return selectFlights(rs);
    }
    public ArrayList<Flight> selectFlights(ResultSet rs){
        ArrayList<Flight> flights = new ArrayList<>();
        try{
            while(rs.next()){
                Flight flight = new Flight();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setLocalDate(rs.getString("local_date"));
                flight.setLocalTime(rs.getString("local_time"));
                flight.setDestination(rs.getString("destination"));
                flight.setSeats(rs.getInt("seats"));
                flight.setFullSeats(rs.getInt("full_seats"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

}
