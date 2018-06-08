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

        if(riderProfile != null && riderProfile.getLifts() != null && !riderProfile.getLifts().isEmpty()) {
            riderRating = 0;
            for (LiftRider liftRider: riderProfile.getLifts()) {
                riderRating += liftRider.getRating();
                ++amountOfRiderRatings;
            }
        }

        if(driverProfile != null && driverProfile.getLifts() != null && !driverProfile.getLifts().isEmpty()) {
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
        if(!(new File("Objects/").exists()))
            new File("Objects/").mkdir();

        if((new File("Objects/" + originalToString()).exists()))
            return false;

        BufferedWriter outputFile = null;

        try {
            outputFile = new BufferedWriter(new FileWriter("Objects/" + originalToString()));

            // Saving the sex
            outputFile.write(Character.toString(sex));
            outputFile.newLine();

            // Saving the birthday
            if(birthday != null)
                outputFile.write(birthday);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the city
            if(city != null)
                outputFile.write(city);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the state
            if(state != null)
                outputFile.write(state);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the telephone
            if(telephone != null)
                outputFile.write(telephone);
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the smoker status
            outputFile.write(smoker? "true" : "false");
            outputFile.newLine();

            // Saving the habilitationTime
            outputFile.write(Integer.toString(habilitationTime));
            outputFile.newLine();

            // Saving the rating
            outputFile.write(Float.toString(rating));
            outputFile.newLine();

            // Saving the rider
            if(riderProfile != null) {
                riderProfile.saveToFile();
                outputFile.write(riderProfile.originalToString());
            } else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the driver
            if(driverProfile != null) {
                driverProfile.saveToFile();
                outputFile.write(driverProfile.originalToString());
            }
            else
                outputFile.write("null");

            outputFile.newLine();

            // Saving the user
            if(user != null) {
                user.saveToFile();
                outputFile.write(user.originalToString());
            }
            else
                outputFile.write("null");

            outputFile.newLine();

            outputFile.flush(); // flushing it before closing, just to be safe.

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not save " + originalToString());
            return false;
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

    public String originalToString() {
        return super.toString();
    }
}