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

    public boolean getSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
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

    @Override
    public String toString() {
        return "Profile{" +
                "sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", telephone='" + telephone + '\'' +
                ", smoker=" + smoker +
                ", habilitationTime=" + habilitationTime +
                ", rating=" + rating +
                ", riderProfile=" + riderProfile +
                ", driverProfile=" + driverProfile +
                ", user=" + user +
                '}';
    }
}