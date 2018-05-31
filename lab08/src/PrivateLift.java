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

    public boolean addRider(Rider r) {
        return getRiders().add(new LiftRider(r, this));
    }

    public boolean addGroup(PrivateGroup pv) {
        return groups.add(pv);
    }

    @Override
    public String toString() {
        return "PrivateLift{" +
                "groups=" + groups +
                '}';
    }
}
