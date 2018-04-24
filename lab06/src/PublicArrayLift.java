import java.util.ArrayList;

public class PublicArrayLift extends ArrayLift{

    private ArrayList<PublicGroup> groups;


    public PublicArrayLift(Driver driver) {
            super(driver);
            groups = new ArrayList<PublicGroup>();
    }

    public boolean addGroup(PublicGroup pb) {
        return groups.add(pb);
    }

    @Override
    public String toString() {
        return "PublicArrayLift{" +
                "groups=" + groups +
                '}';
    }
}
