public abstract class Taxi {
    private String taxiID;
    private String driverName;
    private String location;
    private boolean available;

    public Taxi(String taxiID, String driverName, String location) {
        this.taxiID = taxiID;
        this.driverName = driverName;
        this.location = location;
        this.available = true; // Default to available
    }

    // Getter for taxi ID
    public String getTaxiID() {
        return taxiID;
    }


    // Display taxi details
    public void displayTaxiDetails() {
        System.out.println("Taxi ID: " + taxiID);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Location: " + location);
        System.out.println("Available: " + "Yes");

    }
}
