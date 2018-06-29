import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateGroupGUI extends JFrame{

    public CreateGroupGUI(User user) {

        setTitle("Create Group");

        JLabel name = new JLabel("Name");
        JLabel descriptionLabel = new JLabel("Description");
        JLabel privateLabel = new JLabel("Private?");
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JCheckBox privateCheckBox = new JCheckBox();
        JButton createGroup = new JButton("Create Group");
        Container contentPane = getContentPane();

        name.setBounds(10, 10, 50, 30);
        nameField.setBounds(100, 10, 100, 30);
        descriptionLabel.setBounds(10, 50, 80, 30);
        descriptionField.setBounds(100, 50, 100, 30);
        privateCheckBox.setBounds(10, 105, 20, 20);
        privateLabel.setBounds(30, 100, 100, 30);
        createGroup.setBounds(200, 400, 200, 50);

        createGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                descriptionField.setText("");
                privateCheckBox.setSelected(false);

                if(privateCheckBox.isSelected()) {
                    user.createPrivateGroup(nameField.getText(), descriptionField.getText());

                    JOptionPane.showMessageDialog(null,"Private Group created",
                            "Success",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    user.createPublicGroup(nameField.getText(), descriptionField.getText());
                    JOptionPane.showMessageDialog(null,"Public Group created",
                            "Success",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        contentPane.add(createGroup);
        contentPane.add(nameField);
        contentPane.add(name);
        contentPane.add(descriptionField);
        contentPane.add(descriptionLabel);
        contentPane.add(privateCheckBox);
        contentPane.add(privateLabel);

        setLayout(null);
        setSize(500, 500);
    }
}
