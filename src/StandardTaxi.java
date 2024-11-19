public class StandardTaxi extends Taxi {
    private static final double BASE_FARE = 5.0;
    private static final double RATE_PER_KM = 10.0;

    public StandardTaxi(String taxiID, String driverName, String location) {
        super(taxiID, driverName, location);
    }

    // Calculate fare for StandardTaxi
    public double calculateFare(double distance) {
        return BASE_FARE + (RATE_PER_KM * distance);
    }

    @Override
    public void displayTaxiDetails() {
        super.displayTaxiDetails();
        System.out.println("Taxi Type: Standard");
        System.out.println("Base Fare: " + BASE_FARE);
        System.out.println("Rate Per KM: " + RATE_PER_KM);
    }
}
