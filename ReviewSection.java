package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewSection extends JFrame {
    private JTextArea reviewTextArea;
    private JButton submitReviewButton;

    public ReviewSection() {
        setTitle("Review Section");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        reviewTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(reviewTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        submitReviewButton = new JButton("Submit Review");
        submitReviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String review = reviewTextArea.getText();
                // Process the review (store in a database, display, etc.)
                JOptionPane.showMessageDialog(null, "Review submitted:\n" + review);
                dispose(); // Close the review form
            }
        });
        panel.add(submitReviewButton, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReviewSection();
            }
        });
    }
}
