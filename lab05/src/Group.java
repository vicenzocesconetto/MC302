import java.util.ArrayList;

public /*final*/ class Group {

    private int id;
    private String name;
    private String description;
    private static int idGenerator;
    private ArrayList<User> members;
//    private int staticTest = 42;


//    public int getStaticTest() {
//        return staticTest;
//    }

    static {
        idGenerator = 0;
    }

    public Group() {
        id = idGenerator++;
        members = new ArrayList<User>();
    }

    void addMember(User user) {
        members.add(user);
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

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", members=" + members +
                '}';
    }
}
