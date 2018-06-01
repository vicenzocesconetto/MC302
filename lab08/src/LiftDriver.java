public class LiftDriver {
    private Lift lift;
    private Driver driver;
    private float rating;

    public LiftDriver() {
        rating = 5;
    }

    public LiftDriver(Driver driver) {
        this();
        this.driver = driver;
    }

    public LiftDriver(Lift lift, Driver driver) {
        this();
        this.lift = lift;
        this.driver = driver;
    }

    public LiftDriver(Lift lift, Driver driver, float rating) {
        this.lift = lift;
        this.driver = driver;
        this.rating = rating;
    }

    public Lift getLift() {
        return lift;
    }

    public void setLift(Lift lift) {
        this.lift = lift;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
