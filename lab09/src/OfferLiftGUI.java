import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class OfferLiftGUI extends JFrame {

    public OfferLiftGUI(User user) {

        setTitle("Offer Lift");

        JTextField destinationLatitude = new JTextField("Destination Latitude");
        JTextField destinationLongitude = new JTextField("Destination Longitude");
        JTextField meetingLatitude = new JTextField("Meeting Latitude");
        JTextField meetingLongitude = new JTextField("Meeting Longitude");
        JTextField hourNDay = new JTextField("Hour & Date");
        JTextField price = new JTextField("Price$$$");
        JButton offerLift = new JButton("Offer Lift");
        JCheckBox privateCheckBox = new JCheckBox();
        JLabel privateLabel = new JLabel("Private?");
        Container contentPane = getContentPane();

        destinationLatitude.setBounds(10, 10, 150, 30);
        destinationLongitude.setBounds(180, 10, 150, 30);
        meetingLatitude.setBounds(10, 50, 150, 30);
        meetingLongitude.setBounds(180, 50, 150, 30);
        hourNDay.setBounds(10, 100, 100, 30);
        price.setBounds(10, 130, 100, 30);
        privateCheckBox.setBounds(10, 170, 20, 20);
        privateLabel.setBounds(30, 165, 100, 30);
        offerLift.setBounds(10, 210, 100, 30);

        offerLift.addActionListener((ActionEvent e) -> {
            Lift lift;
            if(privateCheckBox.isSelected()) {
                lift = user.getProfile().getDriverProfile().offerPrivateLift(Float.parseFloat(price.getText()), new ArrayList<PaymentMethod>());
            } else {
                lift = user.getProfile().getDriverProfile().offerPublicLift(Float.parseFloat(price.getText()), new ArrayList<PaymentMethod>());
            }
            lift.setDestinationLatitude(Double.parseDouble(destinationLatitude.getText()));
            lift.setDestinationLongitude(Double.parseDouble(destinationLongitude.getText()));
            lift.setMeetingPointLatitude(Double.parseDouble(meetingLatitude.getText()));
            lift.setMeetingPointLongitude(Double.parseDouble(meetingLongitude.getText()));

            JOptionPane.showMessageDialog(null,"Lift created",
                    "Success",JOptionPane.INFORMATION_MESSAGE);
        });

        contentPane.add(hourNDay);
        contentPane.add(destinationLatitude);
        contentPane.add(destinationLongitude);
        contentPane.add(meetingLatitude);
        contentPane.add(meetingLongitude);
        contentPane.add(price);
        contentPane.add(offerLift);
        contentPane.add(privateCheckBox);
        contentPane.add(privateLabel);

        setLayout(null);
        setSize(500, 500);
    }
}
