import java.util.ArrayList;

public class Lift {
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

    public Lift() {
        maxOccupation = 4;
        riders = new ArrayList<LiftRider>();
        acceptedPaymentMethods = new ArrayList<PaymentMethod>();
    }

    public Lift(LiftDriver driver) {
        this();
        this.driver = driver;
    }

    public Lift(LiftDriver driver, int availableSeats) {
        maxOccupation = availableSeats;
        this.driver = driver;
        riders = new ArrayList<LiftRider>();
        acceptedPaymentMethods = new ArrayList<PaymentMethod>();
    }

    boolean addRider(Rider rider) {
        if(riders.size() < maxOccupation) {
            LiftRider lr = new LiftRider(this, rider);
            rider.addLiftRider(lr);
            return riders.add(lr);
        }
        return false;
    }

    boolean removeRider(Rider rider) {
        for(LiftRider liftRider: riders) {
            if(liftRider.getRider().equals(rider)){
                return riders.remove(liftRider);
            }
        }
        return false;
    }

    boolean removeRider(LiftRider liftRider) {
        for(LiftRider lr : riders) {
            if(liftRider.equals(lr))
                return riders.remove(liftRider);
        }
        return false;
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

    public boolean rateDriver(int userId, float rating) {
        if(driver != null && driver.getDriver() != null) {
            for(LiftRider liftRider : riders) {
                if(liftRider.getRider().getProfile().getUser().getId() == userId) {
                    driver.setRating(rating);
                    driver.getDriver().getDriverProfile().calculateRating();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean rateRiders(float rating) {
        if(riders != null && !riders.isEmpty()) {
            for(LiftRider liftRider : riders) {
                liftRider.setRating(rating);
                liftRider.getRider().getProfile().calculateRating();
            }
            return true;
        } else
            return false;
    }

    @Override
    public String toString() {
        return "Lift{" +
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
