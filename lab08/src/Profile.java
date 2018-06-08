import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Profile implements Comparable<Profile>, Savable {

    private char sex;
    private final String birthday;
    private String city;
    private String state;
    private String telephone;
    private boolean smoker;
    private int habilitationTime;
    private float rating;
    private Rider riderProfile;
    private Driver driverProfile;
    private User user;


    public Profile(char sex, String birthday, String city, String state, String telephone, boolean smoker, int habilitationTime) {
        rating = 5;
        this.setSex(sex);
        this.birthday = birthday;
        this.setCity(city);
        this.setState(state);
        this.setTelephone(telephone);
        this.setSmoker(smoker);
        this.setHabilitationTime(habilitationTime);
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getHabilitationTime() {
        return habilitationTime;
    }

    public void setHabilitationTime(int habilitationTime) {
        this.habilitationTime = habilitationTime;
    }

    public float getRating() {
        return rating;
    }

    public void calculateRating() {
        float finalRating = 0;

        float riderRating = -1;
        int amountOfRiderRatings = 0;

        float driverRating = -1;
        int amountOfDriverRatings = 0;

        if(riderProfile != null && riderProfile.getLifts() != null) {
            riderRating = 0;
            for (LiftRider liftRider: riderProfile.getLifts()) {
                riderRating += liftRider.getRating();
                ++amountOfRiderRatings;
            }
        }

        if(driverProfile != null && driverProfile.getLifts() != null) {
            driverRating = 0;
            for(LiftDriver liftDriver: driverProfile.getLifts()) {
                driverRating += liftDriver.getRating();
                ++amountOfDriverRatings;
            }
        }

        if(riderRating != -1 && driverRating != -1)
            finalRating = (riderRating + driverRating)/(amountOfDriverRatings + amountOfRiderRatings);
        else if (riderRating != -1)
            finalRating = riderRating/amountOfRiderRatings;
        else if (driverRating != -1)
            finalRating = driverRating/amountOfDriverRatings;
        else
            return;

        rating = finalRating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Rider getRiderProfile() {
        return riderProfile;
    }

    public void setRiderProfile(Rider riderProfile) {
        this.riderProfile = riderProfile;
    }

    public Driver getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(Driver driverProfile) {
        this.driverProfile = driverProfile;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int compareTo(Profile o) {
        if(rating > o.getRating())
            return 1;
        else if (rating == o.getRating())
            return 0;
        else
            return -1;
    }

    @Override
    public boolean saveToFile() {
        if(!(new File("Objects").exists()))
            new File("Objects").mkdir();

        if((new File("Objects/" + super.toString()).exists()))
            return false;

        BufferedWriter outputFile = null;

        try {
            outputFile = new BufferedWriter(new FileWriter("Objects/" + super.toString()));

            outputFile.write(Character.toString(sex));
            outputFile.newLine();

            outputFile.write(birthday);
            outputFile.newLine();

            outputFile.write(city);
            outputFile.newLine();

            outputFile.write(state);
            outputFile.newLine();

            outputFile.write(telephone);
            outputFile.newLine();

            outputFile.write(smoker? "true" : "false");
            outputFile.newLine();

            outputFile.write(Integer.toString(habilitationTime));
            outputFile.newLine();

            outputFile.write(Float.toString(rating));
            outputFile.newLine();

            outputFile.write(riderProfile.superToString());
            outputFile.newLine();

            outputFile.write(driverProfile.superToString());
            outputFile.newLine();

            outputFile.write(user.superToString());
            outputFile.newLine();

            outputFile.flush(); // flush it before ending, just to be safe.

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not save " + super.toString());

        } finally {

            try {
                if (outputFile != null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("This is a glitch in the Matrix: Profile.saveToFile()");
            }
        }

        return true;
    }

    @Override
    public String toString() {
        String out = "Profile{" +
                "sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", telephone='" + telephone + '\'' +
                ", smoker=" + smoker +
                ", habilitationTime=" + habilitationTime +
                ", rating=" + rating;
           if(user != null) {
               out += ", userId=" + user.getId();
           }
           if(driverProfile != null) {
               out += ", driverProfile License=" + driverProfile.getDriverLicense();
           }
           if(riderProfile != null) {
               out += ", riderProfile Pays with cash =" + riderProfile.isPayWithCash();
           }
           out += '}';
            return out;
    }

    public String superToString() {
        return super.toString();
    }
}