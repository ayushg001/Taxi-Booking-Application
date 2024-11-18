import java.util.ArrayList;

public class Customer {
    private String customerID;
    private String name;
    private String phoneNumber;
    private ArrayList bookingHistory; // List of bookings

    public Customer(String customerID, String name, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bookingHistory = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }
}