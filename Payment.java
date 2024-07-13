package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Payment extends JFrame {
    private JLabel nameLabel, usernameLabel, PaymentTypeLabel, idLabel, amountLabel;
    private JTextField nameField, usernameField, idField, amountField;
    private JComboBox<String> PaymentTypeComboBox;
    private JButton PayButton;
   // String username;
    public Payment(String username) {
      //  this.username=username;
    setTitle("Payment for Package");
    setSize(500, 400);  // Increased frame size
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(6, 2, 10, 10));

    // Center the frame on the screen
    setLocationRelativeTo(null);

    // Set background color
   // getContentPane().setBackground(new Color(240, 240, 240));

    usernameLabel = new JLabel("Username:");
    usernameField = new JTextField();

    nameLabel = new JLabel("Name:");
    nameField = new JTextField();

    PaymentTypeLabel = new JLabel("Payment Method:");
    String[] paymentTypes = {"RTGS", "UPI"};
    PaymentTypeComboBox = new JComboBox<>(paymentTypes);

    idLabel = new JLabel("Account No.:");
    idField = new JTextField();

    amountLabel = new JLabel("Amount:");
    amountField = new JTextField();

    try {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from account where username = '" + username + "'");
        while (rs.next()) {
            usernameField.setText(rs.getString("username"));
            nameField.setText(rs.getString("name"));
           // amountField.setText(rs.getString("price"));
        }
    } catch (Exception e) {
        System.out.println(e);
    }


    PayButton = new JButton("Pay Now");
    PayButton.setBackground(new Color(0, 102, 204));  // Set button background color
    PayButton.setForeground(Color.WHITE);  // Set button text color
    PayButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Conn co = new Conn();
                String username = usernameField.getText();
                String name = nameField.getText();
                String PaymentType = (String) PaymentTypeComboBox.getSelectedItem();
                String id = idField.getText();
                String amount = amountField.getText();

                // Use PreparedStatement to avoid SQL injection
                String q1 = "INSERT INTO PackagePayment (username, name, payment_type, account_no, amount_paid) VALUES (?, ?, ?, ?,?)";

                try (java.sql.PreparedStatement pst = co.c.prepareStatement(q1)) {
                    pst.setString(1, username);
                    pst.setString(2, name);
                    pst.setString(3, PaymentType);
                    pst.setString(4, id);
                    pst.setString(5, amount);

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Payment Successful via " + PaymentType +
                                "\nTransaction ID: " + generateTransactionId());
                    JOptionPane.showMessageDialog(null, "Payment submitted successfully");
                    JOptionPane.showMessageDialog(null, "Booking Successful");

                    dispose();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Enter details correctly");
            }
        }
    });

    add(usernameLabel);
    add(usernameField);
    add(nameLabel);
    add(nameField);
    add(PaymentTypeLabel);
    add(PaymentTypeComboBox);
    add(idLabel);
    add(idField);
    add(amountLabel);
    add(amountField);
    add(new JLabel()); // Empty label as a placeholder
    add(PayButton);

    // setVisible should be the last statement
    setVisible(true);
}


    private void PayButtonClicked() {
        // Handle the submission logic here
        String username = usernameField.getText();
        String name = nameField.getText();
        String paymentType = (String) PaymentTypeComboBox.getSelectedItem();
        String id = idField.getText();
        String amount = amountField.getText();

        // You can implement the logic to process or store the payment data here
        // For now, let's just print the information to the console
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Payment Type: " + paymentType);
        System.out.println("Account no.: " + id);
        System.out.println("Amount: " + amount);

        // You may want to clear the fields after submission
        usernameField.setText("");
        nameField.setText("");
        PaymentTypeComboBox.setSelectedIndex(0);
        idField.setText("");
        amountField.setText("");
    }
 private String generateTransactionId() {
        // Generate a random transaction ID (for simulation purposes)
        return "TRX" + (int) (Math.random() * 100000);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Payment(""));
    }
}
