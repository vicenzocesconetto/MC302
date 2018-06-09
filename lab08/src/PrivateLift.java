import java.util.ArrayList;

public class PrivateLift extends Lift {

    private ArrayList<PrivateGroup> groups;

    public PrivateLift() {
        super();
        groups = new ArrayList<PrivateGroup>();
    }

    public PrivateLift(LiftDriver driver) {
        super(driver);
        groups = new ArrayList<PrivateGroup>();
    }

    public PrivateLift(LiftDriver driver, int availableSeats) {
        super(driver, availableSeats);
        groups = new ArrayList<PrivateGroup>();
    }

    public boolean addRider(Rider rider) {
        if(groups != null && rider != null && rider.getProfile() != null && rider.getProfile().getUser() != null) {
            for (PrivateGroup pv : groups) {
                if (pv.isUserInGroup(rider.getProfile().getUser())) {
                    LiftRider lr = new LiftRider(this, rider);
                    return getRiders().add(lr) && rider.addRider(lr);
                }
            }
        }
        return false;
    }

    public boolean addGroup(PrivateGroup pv) {
        if(pv.isUserInGroup(getDriver().getDriver().getDriverProfile().getUser())) // We cant add the PrivateLift to a PrivateGroup if the driver isnt in the group
            return groups.add(pv) && pv.getLifts().add(this);
        return false;
    }

    @Override
    public String toString() {
        return "PrivateLift{" +
                "groups=" + groups +
                '}';
    }
}
