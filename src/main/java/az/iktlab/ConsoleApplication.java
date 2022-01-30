package az.iktlab;

import az.iktlab.controller.Controller;
import az.iktlab.enums.Operation;
import az.iktlab.exceptions.OperationNotFoundException;
import az.iktlab.util.Validator;

import java.util.Scanner;

public class ConsoleApplication {

    private static final Controller controller = new Controller();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() throws InterruptedException {

        while (true) {
            System.out.println("1. Online board (SHOW)");
            System.out.println("2. Show the flight info (INFO)");
            System.out.println("3. Search and book a flight (BOOKg)");
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
            else if(Validator.haveOperation.test(operation,Operation.SHOW) ){
                controller.show();
                Thread.sleep(2000);
            }
            else if(Validator.haveOperation.test(operation,Operation.INFO)){
                controller.info();
                Thread.sleep(2000);
            }
            else if(Validator.haveOperation.test(operation,Operation.BOOK)){
                controller.book();
                Thread.sleep(2000);
            }
            else if(Validator.haveOperation.test(operation,Operation.CANCEL)){
                controller.cancel();
                Thread.sleep(2000);
            }
            else if(Validator.haveOperation.test(operation,Operation.FLIGHTS)){
                controller.flights();
                Thread.sleep(2000);
            }
            else if(Validator.haveOperation.test(operation,Operation.EXIT)){
                break;
            }

        }
    }
}
