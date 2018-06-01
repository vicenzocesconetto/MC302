import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private boolean status;
    private ArrayList<GroupUser> groups;
    private Profile profile;
    private static int idGenerator;

    static {
        idGenerator = 0;
    }

    public User() {
        id = idGenerator++;
        groups = new ArrayList<GroupUser>();
    }

    public User(String name) {
        this();
        this.name = name;
    }

    public void createPublicGroup() {
        PublicGroup p = new PublicGroup(this);
    }

    public void createPrivateGroup() {
        PrivateGroup p = new PrivateGroup(this);
    }

    void removeGroup(int id) {
        for (GroupUser i: groups) {
            if(i.getGroup().getId() == id) {
                if ( i.getGroup() instanceof PrivateGroup && !(i.getGroup().getOwner().equals(this)) ) {
                    i.getGroup().getMembers().remove(i);
                    groups.remove(i);
                    return;
                }
            }
        }
    }

    void removeGroup(Group g) {
        for (GroupUser i: groups) {
            if(i.getGroup().equals(g)) {
                if( i.getGroup() instanceof PrivateGroup && !(i.getGroup().getOwner().equals(this)) ) {
                    g.getMembers().remove(i);
                    groups.remove(i);
                    return;
                }
            }
        }
    }

    void updateGroup(User owner, int id, String description, String name) {
        if(!equals(owner))
            return;

        for(GroupUser i: groups) {
            if(i.getGroup().getId() == id) {
                i.getGroup().setDescription(description);
                i.getGroup().setName(name);
                return;
            }
        }
    }

    void updateGroup(User owner, int id, String description) {
        if(!equals(owner))
            return;

        for(GroupUser i: groups) {
            if(i.getGroup().getId() == id) {
                i.getGroup().setDescription(description);
                return;
            }
        }
    }

    void addPublicGroup(PublicGroup group) {
        if(!group.isUserInGroup(this)) {
            GroupUser groupUser = new GroupUser(this);
            groupUser.setGroup(group);
            group.addMember(groupUser);
            groups.add(groupUser);
        }
    }

    boolean addPrivateGroup(User owner, PrivateGroup group) {
        if(owner.equals(group.getOwner()) && !group.isUserInGroup(this)){
            GroupUser groupUser = new GroupUser(this);
            groupUser.setGroup(group);
            groups.add(groupUser);
            group.addMember(groupUser);
            return true;
        }
        return false;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<GroupUser> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<GroupUser> groups) {
        this.groups = groups;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        User.idGenerator = idGenerator;
    }


    public String print() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", groups=" + groups +
                ", profile=" + profile +
                '}';
    }
}
