public abstract class Taxi {
    private String taxiID;
    private String driverName;
    private String location;
    private boolean available;

    public Taxi(String taxiID, String driverName, String location) {
        this.taxiID = taxiID;
        this.driverName = driverName;
        this.location = location;
        this.available = true;
    }

    // Getter for taxi ID
    public String getTaxiID() {
        return taxiID;
    }





}