import java.util.ArrayList;

public class Customer {
    private String customerID;
    private String name;
    private String phoneNumber;
    private ArrayList<Booking> bookingHistory; // List of bookings

    public Customer(String customerID, String name, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bookingHistory = new ArrayList<>();
    }

    // Getter for customer ID
    public String getCustomerID() {
        return customerID;
    }

    // Add a booking to the customer's history
    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
    }

    // Getter for booking history
    public ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    // View booking history
    public void viewBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No bookings found!");
            return; //stops the further execution
        }

        System.out.println("Booking History for Customer ID: " + customerID);
        for (Booking booking : bookingHistory) { //this checks that how many booking are present in bookinghistory arraylist of booking object
            booking.displayBookingDetails();
            System.out.println("------------------------");
        }
    }
}
