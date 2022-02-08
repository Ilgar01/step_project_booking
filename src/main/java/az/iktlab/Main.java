package az.iktlab;

import az.iktlab.create.service.CrudOperationsService;

public class Main
{
    public static void main( String[] args ) throws InterruptedException {

        CrudOperationsService.run();

        System.out.println("Welcome to the program!");

        ConsoleApplication.run();

        System.out.println( "Good Bye, thank you for choosing us :)" );
    }
}
