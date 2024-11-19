public class StandardTaxi extends Taxi {
    private static final double BASE_FARE = 5.0;
    private static final double RATE_PER_KM = 10.0;

  //The super keyword is used to refer to the immediate parent class of a subclass

    public StandardTaxi(String taxiID, String driverName, String location) {
        super(taxiID, driverName, location); //It ensures that the parent class's properties (like taxiID,..,..) are properly initialized
    }

    // Calculate fare for StandardTaxi
    public double calculateFare(double distance) {
        return BASE_FARE + (RATE_PER_KM * distance);
    }

//This annotation indicates that the method displayTaxiDetails() is overriding a method in the parent Taxi class.

    @Override
    public void displayTaxiDetails() {
        super.displayTaxiDetails(); //the super keyword allows you to call the original method from the parent class
        // "super" allows you to reuse the functionality in the Taxi class and then add the specific behavior for StandardTaxi
        System.out.println("Taxi Type: Standard");
        System.out.println("Base Fare: " + BASE_FARE);
        System.out.println("Rate Per KM: " + RATE_PER_KM);
    }
}
