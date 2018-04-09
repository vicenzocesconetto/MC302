import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLift {

    private ArrayList<Rider> riders;
    private final Driver driver;
    private double meetingPointLatitude;
    private double meetingPointLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private String meetingHourDay;
    private int maxOccupation;

    public ArrayLift(Driver driver) {
        this.driver = driver;
        riders = new ArrayList<Rider>();
        maxOccupation = 4;
    }

    public ArrayLift(Driver driver, int availableSeats) {
        this.driver = driver;
        maxOccupation = availableSeats;
        riders = new ArrayList<Rider>();
    }

    boolean addRider(Rider rider) {
        if(riders.size() == maxOccupation)
            return false;

        riders.add(rider);
        return true;
    }

    boolean isRideEmpty() {
        return riders.isEmpty();
    }

    int howManyRiders() {
        return riders.size();
    }

    public ArrayList<Rider> getRiders() {
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
                '}';
    }
}
