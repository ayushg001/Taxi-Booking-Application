import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Customer> customers = new ArrayList<>(); // List of registered customers
    private static ArrayList<Taxi> taxis = new ArrayList<>();         // List of all taxis
    private static int customerCounter = 1001;  // Counter to generate unique customer IDs
    private static int bookingCounter = 2001;   // Counter to generate unique booking IDs

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //we create a infinite while loop and set it true to initialize it
        while (true) {
            // Display the menu
            System.out.println("\nWelcome to the Taxi Booking System!"); // \n is used to create to a blank line before this statement
            System.out.println("1. Register as a Customer");
            System.out.println("2. Book a Taxi");
            System.out.println("3. View Booking History");
            System.out.println("4. Cancel a Booking");
            System.out.println("5. View Available Taxis");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
//A control structure that executes different blocks of code based on the value of choice.
            switch (choice) {
                case 1:
                    registerCustomer(scanner);   // will create these methods later
                    break;                      //Terminates the current case and exits the switch.
                case 2:
                    bookTaxi(scanner);
                    break;
                case 3:
                    viewBookingHistory(scanner);
                    break;
                case 4:
                    cancelBooking(scanner);
                    break;
                case 5:
                    viewAvailableTaxis();
                    break;
                case 6:
                    System.out.println("Thank you for using the Taxi Booking System!");
                    scanner.close();   // Closes the Scanner to free up the input stream resource.
                    return;  // Exits the main() method and stops the program.
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}