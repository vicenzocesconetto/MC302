public class Profile {
    
    char sex;
    String birthday;
    String city;
    String state;
    String telephone;
    boolean smoker;
    int habilitationTime;

    public Profile(char sex, String birthday, String city, String state, String telephone, boolean smoker, int habilitationTime) {
        this.sex = sex;
        this.birthday = birthday;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        this.smoker = smoker;
        this.habilitationTime = habilitationTime;       
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

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

@Override

public String toString() {
    String output = "sex: " + getSex() + "\n" + "birthday: " + getBirthday() + "\n" + 
    "city: " + getCity() + "\n" + "state: " + getState() + "\n";
    output += "telephone: " + getTelephone() + "\n" + "smoker: " + getSmoker() + "\n" + 
    "habilitationTime: " + String.valueOf(habilitationTime) + "\n";
    return output;
}

}