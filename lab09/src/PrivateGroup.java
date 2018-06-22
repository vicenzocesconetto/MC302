import java.util.ArrayList;

public class PrivateGroup extends Group {

    private ArrayList<PrivateLift> lifts;

    public PrivateGroup(User firstOwner) {
        super(firstOwner);
        lifts = new ArrayList<PrivateLift>();
        addMember(firstOwner);
    }

    public ArrayList<PrivateLift> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<PrivateLift> lifts) {
        this.lifts = lifts;
    }

    @Override
    void changeOwner(User old, User newOwner) {
        if(newOwner != null)
            super.changeOwner(old, newOwner);
    }

    /*Since we are not meant to save the lifts arraylist and it's the only instance variable, we just call
    the superclass' saveToFile() and since the Group is abstract we know for sure it will never be saved*/

    @Override
    void addMember(User user) {
        try {
            user.addUserToPrivateGroup(user, this);
        } catch (SystemLiftException e) {
            e.printStackTrace();
            System.out.println("Could not add user: " + user);
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
