import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public GroupUser(Group group) {
        this();
        this.group = group;
    }

    public GroupUser(User user) {
        this();
        this.user = user;
    }

    public GroupUser(Group group, User user) {
        this();
        this.group = group;
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
        if(!(new File("Objects/").exists()))
            new File("Objects/").mkdir();

        if(new File("Objects/" + originalToString()).exists())
            return false;

        BufferedWriter outputFile = null;

        try {
            outputFile = new BufferedWriter(new FileWriter("Objects/" + originalToString()));

            // Saving the id
            outputFile.write(Integer.toString(id));
            outputFile.newLine();

            // Saving the idGenerator
            outputFile.write(Integer.toString(idGenerator));
            outputFile.newLine();

            // Saving the user
            if(user != null) {
                user.saveToFile();
                outputFile.write(user.originalToString());
            } else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the group
            if(group != null) {
                group.saveToFile();
                outputFile.write(group.originalToString());
            } else
                outputFile.write("null");

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
                System.out.println("Glitch in the Matrix: GroupUser.saveToFile()");
            }
        }

        return true;
    }

    @Override
    public String toString() {
        String out = "Group = " + group.getName();
        if(group instanceof PublicGroup)
            out += " - Grupo Publico";
        else
            out += " - Grupo Privado";
        out += "\n";
        return out;
    }

    public String originalToString() {
        return super.toString();
    }
}
