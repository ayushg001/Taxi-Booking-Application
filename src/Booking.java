public class Booking {
    private String bookingID;
    private Customer customer;
    private Taxi taxi;
    private String pickupLocation;
    private String dropLocation;
    private double distance; // in kilometers
    private String status; // "Booked", "Cancelled", etc.

    public Booking(String bookingID, Customer customer, Taxi taxi, String pickupLocation, String dropLocation, double distance) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.taxi = taxi;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distance = distance;
        this.status = "Booked"; // Default status
    }

    // Getter for booking ID
    public String getBookingID() {
        return bookingID;
    }

    // Getter for taxi
    public Taxi getTaxi() {
        return taxi;
    }

//    // Getter for booking status
//    public String getStatus() {
//        return status;
//    }

    // Update booking status
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Method to calculate fare
    public double calculateFare() {
        double baseFare = 5.0; // Base fare
        double ratePerKm = (taxi instanceof PremiumTaxi) ? 15.0 : 10.0; // Premium or standard rate
        return baseFare + (ratePerKm * distance);
    }

    // Display booking details
    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Pickup Location: " + pickupLocation);
        System.out.println("Drop Location: " + dropLocation);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Status: " + status);
        System.out.println("Assigned Taxi: " + taxi.getTaxiID());
    }
}
