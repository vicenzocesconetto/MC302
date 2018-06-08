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

    @Override
    public boolean saveToFile() {
        if(!(new File("Objects/").exists()))
            new File("Objects/").mkdir();

        if((new File("Objects/" + super.toString()).exists()))
            return false;

        BufferedWriter outputFile = null;

        try {
            outputFile = new BufferedWriter(new FileWriter("Objects/" + super.toString()));

            //Saving the id
            outputFile.write(Integer.toString(id));
            outputFile.newLine();

            // Saving the name
            if(name != null)
                outputFile.write(name);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the email
            if(email != null)
                outputFile.write(email);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the password
            if(password != null)
                outputFile.write(password);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the status
            outputFile.write(status ? "true" : "false");
            outputFile.newLine();

            // Saving the groups arraylist
            if(groups != null && !groups.isEmpty()) {
                for(GroupUser groupUser: groups) {
                    groupUser.saveToFile();
                    outputFile.write(groupUser.superToString() + "|");
                }
            } else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the profile
            if(profile != null) {
                profile.saveToFile();
                outputFile.write(profile.superToString());
            }
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the idGenerator: I know it's a static int and all Users will, supposedly, have the same; but if they don't we'll get the greater one
            outputFile.write(Integer.toString(idGenerator));
            outputFile.newLine();

            outputFile.flush(); // flushing it before closing, just to be safe.

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not save " + super.toString());
            return false;
        } finally {

            try {
                if (outputFile != null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("This is a glitch in the Matrix: User.saveToFile()");
            }
        }

        return true;
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

    public String superToString() {
        return super.toString();
    }
}
