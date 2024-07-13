package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TravelFeedbackForm extends JFrame {
    private JLabel nameLabel, usernameLabel, feedbackTypeLabel, commentsLabel;
    private JTextField nameField, usernameField;
    private JComboBox<String> feedbackTypeComboBox;
    private JTextArea commentsArea;
    private JButton submitButton;

    public TravelFeedbackForm(String username) {
        setTitle("Travel Feedback Form");
        setSize(400, 300);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Center the frame on the screen
        setLocationRelativeTo(null);

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        feedbackTypeLabel = new JLabel("Feedback Type:");
        String[] feedbackTypes = {"General", "Booking", "Destinations", "Other"};
        feedbackTypeComboBox = new JComboBox<>(feedbackTypes);

        commentsLabel = new JLabel("Comments:");
        commentsArea = new JTextArea();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '" + username + "'");
            while (rs.next()) {
                usernameField.setText(rs.getString("username"));
                nameField.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        submitButton = new JButton("Submit");
        // ...

submitButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Conn c = new Conn();
            String username = usernameField.getText();
            String name = nameField.getText();
            String feedbackType = (String) feedbackTypeComboBox.getSelectedItem();
            String comments = commentsArea.getText();

            // Use PreparedStatement to avoid SQL injection
            String q1 = "INSERT INTO feedback (username, name, feedback_type, comments) VALUES (?, ?, ?, ?)";
            
            try (java.sql.PreparedStatement pst = c.c.prepareStatement(q1)) {
                pst.setString(1, username);
                pst.setString(2, name);
                pst.setString(3, feedbackType);
                pst.setString(4, comments);

                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Feedback submitted successfully");
                new TravelFeedbackForm("").setVisible(false);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error submitting feedback");
        }
    }
});

// ...


        add(usernameLabel);
        add(usernameField);
        add(nameLabel);
        add(nameField);
        add(feedbackTypeLabel);
        add(feedbackTypeComboBox);
        add(commentsLabel);
        add(commentsArea);
        add(new JLabel()); // Empty label as a placeholder
        add(submitButton);

        // setVisible should be the last statement
        setVisible(true);
    }

    private void submitButtonClicked() {
        // Handle the submission logic here
        String username = usernameField.getText();
        String name = nameField.getText();
        String feedbackType = (String) feedbackTypeComboBox.getSelectedItem();
        String comments = commentsArea.getText();

        // You can implement the logic to process or store the feedback data here
        // For now, let's just print the information to the console
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Feedback Type: " + feedbackType);
        System.out.println("Comments: " + comments);

        // You may want to clear the fields after submission
        usernameField.setText("");
        nameField.setText("");
        feedbackTypeComboBox.setSelectedIndex(0);
        commentsArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TravelFeedbackForm(""));
    }
}
