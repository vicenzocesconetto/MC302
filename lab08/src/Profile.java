public class Profile {

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
}