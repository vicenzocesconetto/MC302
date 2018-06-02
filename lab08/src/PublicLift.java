import java.util.ArrayList;

public class PublicLift extends Lift {

    private ArrayList<PublicGroup> groups;


    public PublicLift() {
        super();
        groups = new ArrayList<PublicGroup>();
    }

    public PublicLift(LiftDriver driver) {
            super(driver);
            groups = new ArrayList<PublicGroup>();
    }

    public boolean addRider(Rider rider) {
        if(groups.isEmpty()) {
            return getRiders().add(new LiftRider(rider, this));
        } else {
            for(PublicGroup pb: groups) {
                if(pb.isUserInGroup(rider.getProfile().getUser()))
                    return getRiders().add(new LiftRider(rider, this));
            }
            return false;
        }
    }

    public boolean addGroup(PublicGroup pb) {
        if(pb.isUserInGroup(getDriver().getDriver().getDriverProfile().getUser()))
            return groups.add(pb) && pb.getLifts().add(this);
        return false;
    }

    @Override
    public String toString() {
        return "PublicLift{" +
                "groups=" + groups +
                '}';
    }
}
