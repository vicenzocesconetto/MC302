import java.util.ArrayList;

public class ArrayLift {

    private ArrayList<LiftRider> riders;
    private LiftDriver driver;
    private double meetingPointLatitude;
    private double meetingPointLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private String meetingHourDay;
    private int maxOccupation;
    private float price;
    private ArrayList<PaymentMethod> acceptedPaymentMethods;

    public ArrayLift(LiftDriver driver) {
        this.driver = driver;
        maxOccupation = 4;
        riders = new ArrayList<LiftRider>();
        acceptedPaymentMethods = new ArrayList<PaymentMethod>();
    }

    public ArrayLift(LiftDriver driver, int availableSeats) {
        this.driver = driver;
        maxOccupation = availableSeats;
        riders = new ArrayList<LiftRider>();
        acceptedPaymentMethods = new ArrayList<PaymentMethod>();
    }

    boolean addRider(LiftRider rider) {
        return riders.size() != maxOccupation && riders.add(rider);
    }

    boolean removeRider(LiftRider rider) {
        return riders.remove(rider);
    }

    boolean isRideEmpty() {
        return riders.isEmpty();
    }

    int checkOccupation() {
        return riders.size();
    }

    boolean addPaymentMethod(PaymentMethod pay) {
        if (pay != PaymentMethod.FREE)
            return acceptedPaymentMethods.add(pay);

        else {
            acceptedPaymentMethods.clear();
            price = 0;
            return acceptedPaymentMethods.add(pay);
        }
    }

    boolean checkPaymentMethod(PaymentMethod pay) {
        return acceptedPaymentMethods.contains(pay);
    }

    boolean isLiftFree() {
        return acceptedPaymentMethods.contains(PaymentMethod.FREE);
    }

    boolean removePaymentMethod(PaymentMethod pay) {
        return acceptedPaymentMethods.remove(pay);
    }

    public ArrayList<LiftRider> getRiders() {
        return riders;
    }

    public double getMeetingPointLatitude() {
        return meetingPointLatitude;
    }

    public void setMeetingPointLatitude(double meetingPointLatitude) {
        this.meetingPointLatitude = meetingPointLatitude;
    }

    public double getMeetingPointLongitude() {
        return meetingPointLongitude;
    }

    public void setMeetingPointLongitude(double meetingPointLongitude) {
        this.meetingPointLongitude = meetingPointLongitude;
    }

    public double getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(double destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public double getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(double destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public String getMeetingHourDay() {
        return meetingHourDay;
    }

    public void setMeetingHourDay(String meetingHourDay) {
        this.meetingHourDay = meetingHourDay;
    }

    public int getMaxOccupation() {
        return maxOccupation;
    }

    public void setMaxOccupation(int maxOccupation) {
        this.maxOccupation = maxOccupation;
    }

    public void setRiders(ArrayList<LiftRider> riders) {
        this.riders = riders;
    }

    public LiftDriver getDriver() {
        return driver;
    }

    public void setDriver(LiftDriver driver) {
        this.driver = driver;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<PaymentMethod> getAcceptedPaymentMethods() {
        return acceptedPaymentMethods;
    }

    public void setAcceptedPaymentMethods(ArrayList<PaymentMethod> acceptedPaymentMethods) {
        this.acceptedPaymentMethods = acceptedPaymentMethods;
    }

    public boolean giveRiderRating(int userId, float rating) {
//        nada aki
    }

    public boolean giveDriverRating(float rating) {
//        nada aki
    }

    @Override
    public String toString() {
        return "ArrayLift{" +
                "riders=" + riders +
                ", driver=" + driver +
                ", meetingPointLatitude=" + meetingPointLatitude +
                ", meetingPointLongitude=" + meetingPointLongitude +
                ", destinationLatitude=" + destinationLatitude +
                ", destinationLongitude=" + destinationLongitude +
                ", meetingHourDay='" + meetingHourDay + '\'' +
                ", maxOccupation=" + maxOccupation +
                ", price=" + price +
                ", acceptedPaymentMethods=" + acceptedPaymentMethods +
                '}';
    }
}
