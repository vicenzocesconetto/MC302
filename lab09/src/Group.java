import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Group implements Savable{

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

    public Group(User owner) {
        this();
        this.owner = owner;
    }

    public Group(User owner, String name) {
        this();
        this.owner = owner;
        this.name = name;
    }

    public Group(User owner, String name, String description) {
        this();
        this.owner = owner;
        this.name = name;
        this.description = description;
    }

    void changeOwner(User old, User newOwner) {
        if(owner.equals(old)) owner = newOwner;
    }

    public boolean isUserInGroup(User user) {
        for(GroupUser groupUser : members) {
            if(user.equals(groupUser.getUser()))
                return true;
        }
        return false;
    }

    public boolean isUserInGroup(GroupUser gp) {
        return members.contains(gp);
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
    public boolean saveToFile() {
        if(!(new File("Objects/").exists()))
            new File("Objects/").mkdir();

        if((new File("Objects/" + originalToString()).exists()))
            return false;

        BufferedWriter outputFile = null;

        try {
            outputFile = new BufferedWriter(new FileWriter("Objects/" + originalToString()));

            // Saving the id
            outputFile.write(Integer.toString(id));
            outputFile.newLine();

            // Saving the name
            if(name != null)
                outputFile.write(name);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the description
            if(description != null)
                outputFile.write(description);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the owner
            if(owner != null) {
                owner.saveToFile();
                outputFile.write(owner.originalToString());
            } else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the members
            if(members != null && !members.isEmpty()) {
                for(GroupUser groupUser : members) {
                    groupUser.saveToFile();
                    outputFile.write(groupUser.originalToString() + "|");
                }
            } else
                outputFile.write("null");

            outputFile.newLine();


            // Saving the idGenerator
            outputFile.write(Integer.toString(idGenerator));
            outputFile.newLine();

            outputFile.flush(); // flushing it before closing, just to be safe.

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not save " + originalToString());
            return false;

        } finally {

            try {
                if (outputFile != null)
                    outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Glitch in the Matrix: Group.saveToFile()");
            }
        }

        return true;
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

    @Override
    public String originalToString() {
        return super.toString();
    }
}
