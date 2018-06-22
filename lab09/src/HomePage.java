import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    public HomePage(User user) {
        setTitle("Stanford Carpool");
        Container contentPane = getContentPane();

        JTextArea textField = new JTextArea("PROFILE\n" +
                "Name: " + user.getName() + "\n" +
                "Email: " + user.getEmail() + "\n" +
                "City: " + user.getProfile().getCity() + "\n" +
                "State: " + user.getProfile().getState() + "\n" +
                "Birthday: " + user.getProfile().getBirthday() + "\n" +
                "Telephone: " + user.getProfile().getTelephone() + "\n\n" +
                "OFFERED LIFTS" + "\n");


        textField.setEditable(false);

        contentPane.add(textField);

        setDefaultCloseOperation(EXIT_ON_CLOSE); /*Without this line, the app doesn't finish when the window is closed*/

        setSize(500, 500); /*The default is set to 0 by 0*/

        setVisible(true); /*If we don't do this, the app just starts and finishes doing "nothing"*/
    }
}