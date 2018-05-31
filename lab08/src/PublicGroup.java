import java.util.ArrayList;

public class PublicGroup extends Group {

    private ArrayList<PublicLift> lifts;


    public PublicGroup() {
        super();
        lifts = new ArrayList<PublicLift>();
    }

    public PublicGroup(PublicLift p) {
        this();
        lifts.add(p);
    }

    public PublicGroup(User firstOwner) {
        super(firstOwner);
    }

    void addLift(PublicLift p) {
        lifts.add(p);
    }

    public ArrayList<PublicLift> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<PublicLift> lifts) {
        this.lifts = lifts;
    }

    public void dynamicTest() {
//        some serious lambdas
        System.out.println("INCBAC - UNIGOU");
    }

    @Override
    void addMember(User user) {
        GroupUser gu = new GroupUser();
        gu.setUser(user);
        gu.setGroup(this);
        user.addGroup(gu);
        getMembers().add(gu);
    }

    @Override
    public String toString() {
        return "PublicGroup{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", members=" + getMembers() +
                '}';
    }
}
