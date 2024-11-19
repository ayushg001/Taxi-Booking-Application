public class PremiumTaxi extends Taxi {
    private static final double BASE_FARE = 10.0;
    private static final double RATE_PER_KM = 15.0;

    public PremiumTaxi(String taxiID, String driverName, String location) {
        super(taxiID, driverName, location);
    }

    // Calculate fare for PremiumTaxi
    public double calculateFare(double distance) {
        return BASE_FARE + (RATE_PER_KM * distance);
    }

    @Override
    public void displayTaxiDetails() {
        super.displayTaxiDetails();
        System.out.println("Taxi Type: Premium");
        System.out.println("Base Fare: " + BASE_FARE);
        System.out.println("Rate Per KM: " + RATE_PER_KM);
    }
}
