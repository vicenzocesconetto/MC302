import java.io.*;
import java.util.ArrayList;

public class User implements Savable{
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
                if (i.getGroup() instanceof PublicGroup || (i.getGroup() instanceof PrivateGroup && !(i.getGroup().getOwner().equals(this)))) {
                    i.getGroup().getMembers().remove(i);
                    groups.remove(i);
                    if(i.getGroup().getOwner().equals(this))
                        i.getGroup().changeOwner(this, null);
                }
                return;
            }
        }
    }

    void removeGroup(Group g) {
        for (GroupUser i: groups) {
            if(i.getGroup().equals(g)) {
                if(i.getGroup() instanceof PublicGroup || (i.getGroup() instanceof PrivateGroup && !(i.getGroup().getOwner().equals(this)))) {
                    g.getMembers().remove(i);
                    groups.remove(i);
                    if(i.getGroup().getOwner().equals(this))
                        i.getGroup().changeOwner(this, null);
                }
                return;
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

    void addUserToPrivateGroup(User user, PrivateGroup group) throws SystemLiftException {
        if(this.equals(group.getOwner()) && !group.isUserInGroup(user)){
            GroupUser groupUser = new GroupUser(user);
            groupUser.setGroup(group);
            user.getGroups().add(groupUser);
            group.addMember(groupUser);
        } else {
            throw new SystemLiftException();
        }
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

    public void saveToFile() {
        if(!(new File("/Objects").exists()))
            new File("/Objects").mkdirs();

        File outPutFile = new File(super.toString());
        DataOutputStream dataOutputStream = null;

        try {

            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(super.toString())));

            try{
                dataOutputStream.writeInt(id);
                dataOutputStream.writeChar((int)'\n');

                if(name != null) {
                    dataOutputStream.writeChars(name);
                    dataOutputStream.writeChar((int) '\n');
                }

                if(email != null) {
                    dataOutputStream.writeChars(email);
                    dataOutputStream.writeChar((int)'\n');
                }

                if(password != null) {
                    dataOutputStream.writeChars(password);
                    dataOutputStream.writeChar((int)'\n');
                }

                dataOutputStream.writeBoolean(status);
                dataOutputStream.writeChar((int)'\n');

//                Save groups and Profile

                dataOutputStream.writeInt(idGenerator);
                dataOutputStream.writeChar((int)'\n');

                dataOutputStream.flush();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Could not write values");
            }

        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Coud not save object " + super.toString());
        } finally {
            try {
                if(dataOutputStream != null) dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
