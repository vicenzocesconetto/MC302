import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {

    public HomePage(User user) {
        setTitle("Stanford Carpool");
        Container contentPane = getContentPane();

        String str = "PROFILE\n" +
                "Name: " + user.getName() + "\n" +
                "Email: " + user.getEmail() + "\n" +
                "City: " + user.getProfile().getCity() + "\n" +
                "State: " + user.getProfile().getState() + "\n" +
                "Birthday: " + user.getProfile().getBirthday() + "\n" +
                "Telephone: " + user.getProfile().getTelephone() + "\n\n" +
                "OFFERED LIFTS\n";
        if(user.getProfile() != null && user.getProfile().getDriverProfile() != null && user.getProfile().getDriverProfile().getLifts() != null && !(user.getProfile().getDriverProfile().getLifts().isEmpty()))
            str += user.getProfile().getDriverProfile().getLifts();
        else
            str += "Not Available";

        str += "\n\nRECEIVED LIFTS\n";

        if(user.getProfile() != null && user.getProfile().getRiderProfile() != null && !(user.getProfile().getRiderProfile().getLifts().isEmpty()))
            str += user.getProfile().getRiderProfile().getLifts();
        else
            str += "Not Available";

        str += "\n\nGRUPOS\n";

        if(user.getGroups() != null)
            str += user.getGroups();
        else
            str += "Not Available";


        JTextArea textField = new JTextArea(str);
        textField.setEditable(false);


        JButton oferecerCarona = new JButton("Oferecer Carona");
        JButton criarGrupo = new JButton("Criar Grupo");

        oferecerCarona.setBounds(20, 300, 200, 30);
        criarGrupo.setBounds(20, 330, 200, 30);

        oferecerCarona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateGroupGUI createGroupGUI = new CreateGroupGUI();
                createGroupGUI.setVisible(true);
            }
        });

        contentPane.add(criarGrupo);
        contentPane.add(oferecerCarona);
        contentPane.add(textField);

        setDefaultCloseOperation(EXIT_ON_CLOSE); /*Without this line, the app doesn't finish when the window is closed*/
        setSize(500, 500); //The default is set to 0 by 0
        setLocationRelativeTo(null); // Use this method to make the window pop-up on the center
        setVisible(true); //If we don't do this, the app just starts and finishes doing "nothing"
    }
}