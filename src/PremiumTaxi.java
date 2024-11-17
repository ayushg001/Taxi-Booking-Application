public class PremiumTaxi extends Taxi {
    private static final double BASE_FARE = 10.0;
    private static final double RATE_PER_KM = 15.0;

    public PremiumTaxi(String taxiID, String driverName, String location) {
        super(taxiID, driverName, location);
    }


}