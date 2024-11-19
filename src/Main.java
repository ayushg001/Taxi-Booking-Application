import java.util.ArrayList; //array list is dynamic array that can store objects
import java.util.Scanner;

public class Main {
    private static ArrayList<Customer> customers = new ArrayList<>(); // List of registered customers
    //    The <Customer> part specifies that this list will store only Customer objects.
    private static ArrayList<Taxi> taxis = new ArrayList<>();         // List of all taxis
    private static int customerCounter = 1001;  // Counter to generate unique customer IDs
    private static int bookingCounter = 2001;   // Counter to generate unique booking IDs

    public static void main(String[] args) {
        initializeTaxis(); //  By calling initializeTaxis() at the start of the main() method, we ensure that the program
        // initializes with some sample taxi data . This early invocation means that when the user runs the program
        // and selects options such as "Book a Taxi" or "View Available Taxis," there will already be some taxis available
        // in the system.
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
            scanner.nextLine(); // Consume the newline character .........
//A control structure that executes different blocks of code based on the value of choice.
            switch (choice) {
                case 1:
                    registerCustomer(scanner);
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

    // Register a new customer
    private static void registerCustomer(Scanner scanner) { // Scanner scanner is A parameter that allows the method to read user input.
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();  //Reads the full line of input (including spaces) from the user

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        String customerID = name + customerCounter++;
        Customer customer = new Customer(customerID, name, phoneNumber); // parameters
        customers.add(customer);    //The new Customer object (e.g., customer) is added to the customers arraylist.

        System.out.println("Registration successful! Your Customer ID is: " + customerID);
    }

    // Book a taxi
    private static void bookTaxi(Scanner scanner) {
        System.out.print("Enter your Customer ID: ");
        String customerID = scanner.nextLine();

        Customer customer = findCustomerByID(customerID); //checking customerID is present in customer obj or not
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.print("Enter Pickup Location: ");
        String pickupLocation = scanner.nextLine();

        System.out.print("Enter Drop Location: ");
        String dropLocation = scanner.nextLine();

        System.out.print("Select Taxi Type (1 for Standard, 2 for Premium): ");
        int taxiType = scanner.nextInt();
        scanner.nextLine(); // The nextLine() method reads all the text entered by the user until they press Enter.

        Taxi availableTaxi = findAvailableTaxi(taxiType);
        if (availableTaxi == null) {
            System.out.println("No taxis available for the selected type!");
            return;
        }

        double distance = 22; // Generate random distance (5-20 km)
        String bookingID = "BOOK" + bookingCounter++;
        Booking booking = new Booking(bookingID, customer, availableTaxi, pickupLocation, dropLocation, distance);
        customer.addBooking(booking);
        //The new Booking object (created earlier in the code) is added to the customer's booking history (bookingHistory list).


        System.out.println("Booking confirmed!");
        System.out.println("Your Booking ID is: " + bookingID);
        System.out.println("Assigned Taxi ID: " + availableTaxi.getTaxiID());
        System.out.println("Estimated Fare: $" + booking.calculateFare());
    }

    // View booking history for a customer
    private static void viewBookingHistory(Scanner scanner) {
        System.out.print("Enter your Customer ID: ");
        String customerID = scanner.nextLine();

        Customer customer = findCustomerByID(customerID);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        customer.viewBookingHistory();
    }

    // Cancel a booking
    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter your Customer ID: ");
        String customerID = scanner.nextLine();

        Customer customer = findCustomerByID(customerID);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.print("Enter your Booking ID: ");
        String bookingID = scanner.nextLine();

        for (Booking booking : customer.getBookingHistory()) { //1 2 3
            if (booking.getBookingID().equals(bookingID)) { //equal

                booking.updateStatus("Cancelled");

                System.out.println("Booking successfully cancelled.");}
            else {
                System.out.println("Booking not found!");
            }
            return;

        }

//        System.out.println("Booking not found!");
    }

    // View available taxis
    private static void viewAvailableTaxis() {
        System.out.println("Available Taxis:");
        for (Taxi taxi : taxis) {  // Loop through each taxi in the 'taxis' list

            taxi.displayTaxiDetails();

        }
    }

    // Initialize taxis
    private static void initializeTaxis() {
        taxis.add(new StandardTaxi("TAXI1001", "Driver A", "waknaghat")); //This creates a new object of the StandardTaxi class
        taxis.add(new StandardTaxi("TAXI1002", "Driver B", "solan"));
        taxis.add(new PremiumTaxi("TAXI2001", "Driver C", "shimla"));
        taxis.add(new PremiumTaxi("TAXI2002", "Driver D", "chandigarh"));
    }

    // Find customer by ID
    private static Customer findCustomerByID(String customerID) {
        for (Customer customer : customers) { //1 2 ...     //Loop will go through each customer in the customers list.
            if (customer.getCustomerID().equals(customerID)) {
                // if It finds that customer.getCustomerID() equals "akash1001", so it returns the customer object for akash.

                return customer;
            }
        }
        return null;  //no customer was found with that ID
    }

    // Find an available taxi by type
    private static Taxi findAvailableTaxi(int taxiType) {
        for (Taxi taxi : taxis) {
            //The "instanceof" operator helps to distinguish between different subclasses of Taxi
            if ((taxiType == 1 && taxi instanceof StandardTaxi) || (taxiType == 2 && taxi instanceof PremiumTaxi)) {
                return taxi;
            }
        }
        return null;
    }
}
