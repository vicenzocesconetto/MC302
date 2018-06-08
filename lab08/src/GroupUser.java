public class GroupUser implements Savable{
    private int id;
    private static int idGenerator;
    private User user;
    private Group group;

    static {
        idGenerator = 0;
    }

    public GroupUser() {
        id = idGenerator++;
    }

    public GroupUser(User user) {
        this();
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean saveToFile() {
        return true;
    }

    @Override
    public String toString() {
        String out = "GroupUser{" +
                "id=" + id;
                if(user != null) {
                    out += ", user=" + user.getName();
                }
                if(group != null) {
                    out += ", group Id=" + group.getId();
                }
                out += '}';
                return out;
    }

    public String superToString() {
        return super.toString();
    }
}
