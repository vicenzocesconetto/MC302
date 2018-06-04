import java.util.ArrayList;

public class PrivateGroup extends Group {

    private ArrayList<PrivateLift> lifts;

    public PrivateGroup(User firstOwner) {
        super(firstOwner);
        lifts = new ArrayList<PrivateLift>();
        addMember(firstOwner);
    }

    public PrivateGroup(User firstOwner, PrivateLift p) {
        super();
        lifts = new ArrayList<PrivateLift>();
        lifts.add(p);
    }

    void addLift(PrivateLift p) {
        lifts.add(p);
    }

    public ArrayList<PrivateLift> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<PrivateLift> lifts) {
        this.lifts = lifts;
    }

    @Override
    void addMember(User user) {
        if(!isUserInGroup(user)) {

        }
    }

    void addMember(GroupUser gp) {
        if(!isUserInGroup(gp.getUser())) {
            getMembers().add(gp);
        }
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
