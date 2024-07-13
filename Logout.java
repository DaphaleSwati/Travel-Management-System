package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logout extends JFrame {
    public static void main(String[] args) {
        new Logout().setVisible(true);
    }

    public Logout() {
        setBounds(400, 150, 800, 400); // Larger frame size
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton btnSignOut = new JButton("Log Out");
        btnSignOut.setFont(new Font("times new roman", Font.BOLD, 24)); // Increased font size
        btnSignOut.setForeground(Color.white);
        btnSignOut.setBackground(new Color(0, 102, 204));
        btnSignOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
        });

        btnSignOut.setBounds(300, 150, 200, 60); // Adjusted button size and position
        panel.add(btnSignOut);

        JLabel label = new JLabel("Travel and Tourism Management System");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("algerian", Font.BOLD, 24)); // Increased font size
        label.setBounds(7, 50, 800, 30); // Adjusted label position
        label.setForeground(Color.red);
        panel.add(label);

        setVisible(true);
    }
} 