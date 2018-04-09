public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private boolean status;

    public User(int id, String name, String email, String password, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

@Override 
    public String toString() {
        String output = getName() + " (id: "+ getId() + ")\n";
        output = output + "email: " + getEmail()+"\n";
        output = output + "password: " + getPassword() +"\n";
        output = output + "status: " + getStatus() + "\n";
        return output;  
    }
}