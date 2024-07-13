package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Instructions extends JFrame implements ActionListener {

    JButton exitButton1;
    JLabel titleLabel;
    Font font, titleFont, contentFont;
    JTextArea instructionsTextArea;
    String instructionsText;

    public Instructions() {
        System.out.println("Instructions window created");
        setLayout(null);

        font = new Font("RALEWAY", Font.BOLD, 16);
        setFont(font);

        instructionsText = "             **********General Instructions**********\n\n"
                + "Ensure you have a valid passport and any necessary visas.\n"
                + "Double-check your travel dates and itinerary.\n"
                + "Confirm accommodation reservations and transportation details.\n"
                + "Keep emergency contact information handy.\n\n"
                + "             **********Precautions**********\n\n"
                + "Be aware of local laws and customs at your destination.\n"
                + "Keep your belongings secure, especially in crowded areas.\n"
                + "Stay hydrated and be mindful of food safety practices.\n"
                + "Follow any health advisories or vaccination requirements.\n\n"
                + "             **********Things to Carry**********\n\n"
                + "Passport, tickets, and any required travel documents.\n"
                + "Personal identification, such as driver's license or ID card.\n"
                + "Medications and a basic first aid kit.\n"
                + "Travel adapter and chargers for electronic devices.\n"
                + "Comfortable clothing and appropriate attire for your destination.\n\n"
                + "             **********Inclusive Expenses**********\n\n"
                + "Accommodation costs (hotels,food etc.).\n"
                + "Transportation expenses (flights from Mumbai Airport,trains, rental cars, etc.).\n"
                + "Meals and dining expenses.\n"
                + "Entrance fees for attractions and activities.\n"
                + "Travel insurance costs.\n\n"
                + "             **********Exclusive Expenses**********\n\n"
                + "Personal shopping and souvenirs.\n"
                + "Extra activities or excursions not included in the package.\n"
                + "Tips and gratuities for service providers.\n"
                + "Emergency expenses or unexpected costs.\n\n"
                + "             **********Safety Tips**********\n\n"
                + "Keep a copy of important documents in a separate location.\n"
                + "Be cautious of your surroundings, especially in unfamiliar areas.\n"
                + "Use reputable transportation services and accommodations.\n"
                + "Keep emergency numbers and contacts saved in your phone.\n\n"
                + "             **********Cultural Sensitivity**********\n\n"
                + "Respect local customs and traditions.\n"
                + "Dress modestly if required by the local culture.\n"
                + "Learn basic phrases in the local language.\n"
                + "Be mindful of cultural nuances and etiquette.\n\n"
                + "             **********Environmental Responsibility**********\n\n"
                + "Dispose of waste responsibly and recycle when possible.\n"
                + "Conserve energy and water resources.\n"
                + "Support local businesses and communities.\n"
                + "Respect natural habitats and wildlife.\n\n"
                + "             **********Health and Wellness**********\n\n"
                + "Carry necessary medications and prescriptions.\n"
                + "Stay hydrated and protect yourself from the sun.\n"
                + "Get sufficient rest and sleep.\n"
                + "Be aware of local healthcare facilities and emergency services.\n\n"
                + "             **********Emergency Procedures**********\n\n"
                + "Know the location of the nearest embassy or consulate.\n"
                + "Familiarize yourself with emergency evacuation routes.\n"
                + "Keep a list of emergency contacts, including local authorities.\n"
                + "Follow any guidance or instructions from local authorities in case of emergencies.";

        instructionsTextArea = new JTextArea(instructionsText);
        instructionsTextArea.setEditable(false);
        instructionsTextArea.setLineWrap(true);
        instructionsTextArea.setWrapStyleWord(true);
        instructionsTextArea.setBackground(new Color(208,230,253));
        instructionsTextArea.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 16));

        JScrollPane scrollPane = new JScrollPane(instructionsTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(20, 100, 450, 300);
        add(scrollPane);

        titleFont = new Font("algerian", Font.BOLD, 26);
        titleLabel = new JLabel("Travel Instructions");
        titleLabel.setBounds(100, 10, 550, 80);
        titleLabel.setForeground(Color.red);
        titleLabel.setFont(titleFont);
        add(titleLabel);

        exitButton1 = new JButton("Exit");
        exitButton1.setBounds(180, 430, 120, 20);
        exitButton1.addActionListener(this);
        add(exitButton1);

        setBounds(700, 220, 500, 500);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        dispose();
    }

    public static void main(String args[]) {
        new Instructions().setVisible(true);
    }
}
