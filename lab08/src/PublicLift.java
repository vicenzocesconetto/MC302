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

    public boolean addRider(Rider r) {
        return getRiders().add(new LiftRider(r, this));
    }

    public boolean addGroup(PublicGroup pb) {
        return groups.add(pb);
    }

    @Override
    public String toString() {
        return "PublicLift{" +
                "groups=" + groups +
                '}';
    }
}
