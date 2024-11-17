public class StandardTaxi extends Taxi {
    private static final double BASE_FARE = 5.0;
    private static final double RATE_PER_KM = 10.0;

    public StandardTaxi(String taxiID, String driverName, String location) {
        super(taxiID, driverName, location);
    }


}