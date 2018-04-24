public class LiftDriver {
    private ArrayLift lift;
    private Driver driver;
    private float rating;

    public LiftDriver() {
    }

    public LiftDriver(Driver driver) {
        this.driver = driver;
    }

    public LiftDriver(ArrayLift lift, Driver driver) {
        this.lift = lift;
        this.driver = driver;
    }

    public LiftDriver(ArrayLift lift, Driver driver, float rating) {
        this.lift = lift;
        this.driver = driver;
        this.rating = rating;
    }

    public ArrayLift getLift() {
        return lift;
    }

    public void setLift(ArrayLift lift) {
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
