package az.iktlab;

import az.iktlab.controller.Controller;
import az.iktlab.entity.Flight;
import az.iktlab.enums.Operation;
import az.iktlab.exceptions.OperationNotFoundException;
import az.iktlab.util.Validator;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {

    private static final Controller controller = new Controller();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() throws InterruptedException {

        while (true) {
            System.out.println("1. Online board (SHOW)");
            System.out.println("2. Show the flight info (INFO)");
            System.out.println("3. Search and book a flight (SEARCH)");
            System.out.println("4. Cancel the booking (CANCEL)");
            System.out.println("5. My flights (FLIGHTS)");
            System.out.println("6. Exit (EXIT)");

            System.out.print("Enter operation : ");
            String operation = scanner.nextLine();

            if (Validator.isOperation(operation)) {
                try {
                    throw new OperationNotFoundException();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Thread.sleep(3000);
            }
            else if(operation.trim().equalsIgnoreCase(Operation.SHOW.name())){
                controller.show();
                Thread.sleep(2000);
            }
            else if(operation.trim().equalsIgnoreCase(Operation.INFO.name())){
                System.out.println("Please flight id: ");
                String flightId = scanner.nextLine();
                controller.getFlightById(flightId);
            }
            else if(operation.trim().equalsIgnoreCase(Operation.SEARCH.name())){
                System.out.print("Please destination,date and number of people:\n Destination: ");
                String destination = scanner.nextLine();
                System.out.print("Date: ");
                String date = scanner.nextLine();
                System.out.print("Number of people: ");
                int numberOfPeople = scanner.nextInt();
                List<Flight> flights =  controller.search(destination,date,numberOfPeople);

                System.out.println("Please select the operation number you want.\n0.(Back)");
                flights.forEach(System.out::println);
                int operationTwo = scanner.nextInt();
                scanner.nextLine();
                if(operationTwo != 0)
                    controller.booking(operationTwo);
            }
            else if(operation.trim().equalsIgnoreCase(Operation.CANCEL.name())){
                System.out.println("Please booking id: ");
                String bookingId = scanner.nextLine();
                controller.cancel(bookingId);
            }
            else if(operation.trim().equalsIgnoreCase(Operation.FLIGHTS.name())){
                System.out.println("Please full name: ");
                String fullName = scanner.nextLine();
                controller.userFlights(fullName);
            }
            else if(operation.trim().equalsIgnoreCase(Operation.EXIT.name())){
                break;
            }

        }
    }
}
