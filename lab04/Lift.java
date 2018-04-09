import java.util.Arrays;

public class Lift {

    private /*final*/ Rider[] riders;
    private final Driver driver;
    private double meetingPointLatitude;
    private double meetingPointLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private String meetingHourDay;
    private int maxOccupation;
    private int availableSeats;

    public Lift(Driver driver) {
        this.driver = driver;
        maxOccupation = 4;
        riders = new Rider[maxOccupation];
    }

    public Lift(Driver driver, int availableSeats) {
        this.driver = driver;
        maxOccupation = availableSeats;
        riders = new Rider[maxOccupation];
    }

    boolean addRider(Rider rider) {
        if(riders[maxOccupation-1] != null)
            return false;

        for (int i = 0; i < maxOccupation; i++) {
            if(riders[i] == null) {
                riders[i] = rider;
                break;
            }
        }
        return true;
    }

    boolean isRideEmpty() {
        if(riders[0] == null)
            return true;
        else
            return false;
    }

    int howManyRiders() {
        int i = 0;
        for (; i < maxOccupation && riders[i] != null; ++i) {}

        return i;
    }

    public Rider[] getRiders() {
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Lift{" +
                "riders=" + Arrays.toString(riders) +
                ", driver=" + driver +
                ", meetingPointLatitude=" + meetingPointLatitude +
                ", meetingPointLongitude=" + meetingPointLongitude +
                ", destinationLatitude=" + destinationLatitude +
                ", destinationLongitude=" + destinationLongitude +
                ", meetingHourDay='" + meetingHourDay + '\'' +
                ", maxOccupation=" + maxOccupation +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
