package az.iktlab.booking.controller;

import az.iktlab.ConsoleApplication;
import az.iktlab.booking.service.BookService;
import az.iktlab.entity.Flight;
import az.iktlab.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BookController {
   public static void book() throws InterruptedException {
      Scanner scan = new Scanner(System.in);
      Flight flight = new Flight();
      System.out.print("Search for a flight \nDestination: ");
      flight.setDestination(scan.next());
      System.out.print("Date (YYYY-MM-DD): ");
      flight.setLocalDate(scan.next());
      System.out.print("Number of people: ");
      int numberPeople = scan.nextInt();
      BookService bookService = new BookService();
      ArrayList<Flight> flights = bookService.search(flight,numberPeople);
      if(!flights.isEmpty()){
         System.out.println("__________________________________________________" +
                 "________________________________________________________");
         for (Flight f:flights)
         {
            System.out.println(f);
            System.out.println("__________________________________________________" +
                    "________________________________________________________");
         }
         System.out.println("select a flight id or return main menu (0)");
         int selectedId = scan.nextInt();
         if(selectedId==0){
            ConsoleApplication.run();
         }
         else {
            Person person = new Person();
            Person[] persons = new Person[numberPeople];
            for (int i=0;i<numberPeople;i++){
               System.out.printf("%d.passenger \nfull name (name surname): ",i+1);
               person.setPersonName(scan.next());
               person.setPersonSurname(scan.next());
               persons[i]=person;
            }
            System.out.printf("your booking id: %s \n",Arrays.toString(bookService.book(persons,selectedId)));
         }
      }else
      {
         System.out.println("No result");
         System.out.println("try again(1) or return main menu(any key)");
         String selected = scan.next();
         if(selected.equals("1")){
            book();
         }
         else {
            ConsoleApplication.run();
         }
      }

   }
   public static void cancel(){
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter your booking Id: ");
      int bookId = scan.nextInt();
      BookService bookService = new BookService();
      System.out.println( bookService.cancel(bookId));
   }

   public static void myFlights() throws InterruptedException {
      System.out.print("Enter full name (name surname): ");
      Person person=new Person();
      Scanner scan = new Scanner(System.in);
      person.setPersonName(scan.next());
      person.setPersonSurname(scan.next());
      BookService bookService = new BookService();
      ArrayList<Flight> myFlights = bookService.myFlights(person);
      if(!myFlights.isEmpty()) {
         System.out.println("__________________________________________________" +
                 "________________________________________________________");
         for (Flight f : myFlights) {
            System.out.println(f);
            System.out.println("__________________________________________________" +
                    "________________________________________________________");
         }
      } else
      {
         System.out.println("No result");
         System.out.println("try again(1) or return main menu(any key)");
         String selected = scan.next();
         if(selected.equals("1")){
            myFlights();
         }
         else {
            ConsoleApplication.run();
         }
      }
   }
}
