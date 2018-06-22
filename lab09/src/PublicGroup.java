import java.util.ArrayList;

public class PublicGroup extends Group implements Savable{

    private ArrayList<PublicLift> lifts;

    public PublicGroup() {
        super();
        lifts = new ArrayList<PublicLift>();
    }

    public PublicGroup(User firstOwner) {
        super(firstOwner);
        lifts = new ArrayList<PublicLift>();
        addMember(firstOwner);
    }

    public ArrayList<PublicLift> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<PublicLift> lifts) {
        this.lifts = lifts;
    }

//    public void dynamicTest() {
////        some serious lambdas
//        System.out.println("INCBAC - UNIGOU");
//    }

    /*Since we are not meant to save the lifts arraylist and it's the only instance variable, we just call
    the superclass' saveToFile() and since the Group is abstract we know for sure it will never be saved*/

    @Override
    void addMember(User user) {
        if(!isUserInGroup(user)) {
            user.addPublicGroup(this);
        }
    }

    void addMember(GroupUser gp) {
        if(!isUserInGroup(gp.getUser())) {
            getMembers().add(gp);
        }
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
