import java.util.ArrayList;

public class PrivateArrayLift extends ArrayLift {

    private ArrayList<PrivateGroup> groups;


    public PrivateArrayLift(LiftDriver driver) {
        super(driver);
        groups = new ArrayList<PrivateGroup>();
    }

    public boolean addGroup(PrivateGroup pv) {
        return groups.add(pv);
    }

    @Override
    public String toString() {
        return "PrivateArrayLift{" +
                "groups=" + groups +
                '}';
    }
}
