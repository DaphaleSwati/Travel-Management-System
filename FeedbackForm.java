package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackForm extends JFrame {
    private JTextArea feedbackTextArea;
    private JButton submitButton;
    private JTextField usernameField; // Added field for username
    private JPanel contentPane;

    public FeedbackForm(String username) {
        setTitle("Feedback Form");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        System.out.println(username);
        setBounds(80, 220, 450, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Display username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(200, 190, 70, 20);
        contentPane.add(usernameLabel);

        usernameField = new JTextField(username);
        usernameField.setBounds(271, 190, 150, 20);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        usernameField.setEditable(false); // Make it non-editable

        feedbackTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(feedbackTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        submitButton = new JButton("Submit Feedback");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedback = feedbackTextArea.getText();
                // Process the feedback (store in a database, send to server, etc.)
                JOptionPane.showMessageDialog(null, "Feedback submitted:\nUsername: " + username + "\nFeedback: " + feedback);
                dispose(); // Close the feedback form
            }
        });
        panel.add(submitButton, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // You can pass the actual username of the currently logged user here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FeedbackForm("JohnDoe");
            }
        });
    }
}
