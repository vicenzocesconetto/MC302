public class LiftRider {
    private Rider rider;
    private Lift lift;
    private float rating;

    public LiftRider() {
        rating = 5;
    }

    public LiftRider(Rider rider) {
        this();
        this.rider = rider;
    }

    public LiftRider(Lift lift, Rider rider) {
        this();
        this.rider = rider;
        this.lift = lift;
    }

    public LiftRider(Lift lift, Rider rider, float rating) {
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

    public Lift getLift() {
        return lift;
    }

    public void setLift(Lift lift) {
        this.lift = lift;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
