import java.util.ArrayList;

public abstract class Group {

    private int id;
    private String name;
    private String description;
    private User owner;
    private static int idGenerator;
    private ArrayList<GroupUser> members;


    static {
        idGenerator = 0;
    }

    public Group() {
        id = idGenerator++;
        members = new ArrayList<GroupUser>();
    }

    public Group(User firstOwner) {
        this();
        owner = firstOwner;
    }

    void changeOwner(User old, User newOwner) {
        GroupUser newGroupUser = new GroupUser();

        newGroupUser.setUser(newOwner);
        newGroupUser.setGroup(this);

        members.add(newGroupUser);

        newOwner.addGroup(newGroupUser);

        ArrayList<GroupUser> search = old.getGroups();
        GroupUser find = null;
        for (GroupUser i : search) {
            if(i.getUser().equals(old)) {
                find = i;
                break;
            }
        }
        old.removeGroup(find);
        members.remove(find);
    }

    abstract void addMember(User user);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Group.idGenerator = idGenerator;
    }

    public ArrayList<GroupUser> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<GroupUser> members) {
        this.members = members;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", members=" + members +
                '}';
    }
}
