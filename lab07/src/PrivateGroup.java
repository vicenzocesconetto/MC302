import java.util.ArrayList;

public class PrivateGroup extends Group {

    private ArrayList<PrivateLift> lifts;


    public PrivateGroup() {
        super();
        lifts = new ArrayList<PrivateLift>();
    }

    public PrivateGroup(PrivateLift p) {
        this();
        lifts.add(p);
    }

    void addLift(PrivateLift p) {
        lifts.add(p);
    }

    public PrivateGroup(User firstOwner) {
        super(firstOwner);
    }

    public ArrayList<PrivateLift> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<PrivateLift> lifts) {
        this.lifts = lifts;
    }

    @Override
    void addMember(User user) {
        GroupUser gu = new GroupUser();
        gu.setUser(user);
        user.addGroup(gu);
        getMembers().add(gu);
        gu.setGroup(this);
    }

    @Override
    public String toString() {
        return "PrivateGroup{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", members=" + getMembers() +
                '}';
    }
}
