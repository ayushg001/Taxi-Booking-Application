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


}