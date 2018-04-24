public class LiftRider {
    private Rider rider;
    private ArrayLift lift;
    private float rating;

    public LiftRider() {
    }

    public LiftRider(Rider rider) {
        this.rider = rider;
    }

    public LiftRider(Rider rider, ArrayLift lift) {
        this.rider = rider;
        this.lift = lift;
    }

    public LiftRider(Rider rider, ArrayLift lift, float rating) {
        this.rider = rider;
        this.lift = lift;
        this.rating = rating;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public ArrayLift getLift() {
        return lift;
    }

    public void setLift(ArrayLift lift) {
        this.lift = lift;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
