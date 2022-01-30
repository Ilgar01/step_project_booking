package az.iktlab.controller;


import az.iktlab.entity.Flight;

import java.util.Arrays;
import java.util.List;

public class Controller {

    public void show(){
        System.out.println("Show is work");
    }

    public void getFlightById(String flightId){

    }

    public boolean cancel(String bookingId){
        return true;
    }

    public void userFlights(String fullName) {
    }

    public List<Flight> search(String destination, String date, int numberOfPeople) {
        return Arrays.asList(new Flight(),new Flight());
    }

    public boolean booking(int operation) {
        return false ;
    }
}
