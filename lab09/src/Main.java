import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        User user = new User("Vicenzo", "vicenzo@analytica.com", "Alphabet", true);
        Profile profile = new Profile('M', "17/08/1984", "Palo Alto", "Golden State", "33300641", false, 1);
        user.setProfile(profile);

        HomePage homePage = new HomePage(user);
    }
}






















