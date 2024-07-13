package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends JFrame implements ActionListener{
    String username;
    
    JButton addyourdetails,ViewHotels,BookHotel,ViewBookedHotels,Feedback,logout,abt,instruction,Payment;
    JButton updateyourdetails,deleteyourdetails,destinations,CheckPackage,BookPackage,ViewPackage,Paymenthotel;
    Home(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        JPanel p1=new JPanel(); 
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,70);
        add(p1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1600, 1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5); 
	JLabel image = new JLabel(i6);
	image.setBounds(0, 0, 1600, 1000); 
        add(image);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(5, 0, 70, 70); 
        p1.add(NewLabel);
        
        JLabel heading= new JLabel("Dashboard");
        heading.setBounds(80, 10,300,40);
        heading.setForeground(new Color(161,251,142));
        heading.setFont(new Font("Algerian", Font.BOLD, 25));
        p1.add(heading);
        setVisible(true);
        
        JLabel l1 = new JLabel("Travel and Tourism Management System");
	l1.setForeground(Color.RED);
        l1.setFont(new Font("Vineta BT", Font.ITALIC, 35));
	l1.setBounds(350, 60, 1500, 200);
	image.add(l1);
        
        JPanel p2 = new JPanel(); 
        p2.setLayout(new GridLayout(17,1,0,0));
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);
        
        
        addyourdetails = new JButton("Add Your Details");
        addyourdetails.setBounds(0, 0,300,50);
        addyourdetails.setBackground(new Color(0,0,102));
        addyourdetails.setForeground(new Color(255,254,145));
        addyourdetails.setFont(new Font("Tahuma", Font.BOLD, 16));
        addyourdetails.setMargin(new Insets(5,5,5,5));
        addyourdetails.addActionListener(this);
        p2.add(addyourdetails);
        
        updateyourdetails = new JButton("Update Your Details");
        updateyourdetails.setBounds(0, 50,300,40);
        updateyourdetails.setBackground(new Color(0,0,102));
        updateyourdetails.setForeground(new Color(255,254,145));
        updateyourdetails.setFont(new Font("Tahuma", Font.BOLD, 16));
        updateyourdetails.setMargin(new Insets(5,5,5,5));
        updateyourdetails.addActionListener(this);
        //p2.add(updateyourdetails);
        
        deleteyourdetails = new JButton("User Profile");
        deleteyourdetails.setBounds(0, 90,300,40);
        deleteyourdetails.setBackground(new Color(0,0,102));
        deleteyourdetails.setForeground(new Color(255,254,145));
        deleteyourdetails.setFont(new Font("Tahuma", Font.BOLD, 16));
        deleteyourdetails.setMargin(new Insets(5,5,5,5));
        deleteyourdetails.addActionListener(this);
        //p2.add(deleteyourdetails);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 130,300,40);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(new Color(255,254,145));
        destinations.setFont(new Font("Tahuma", Font.BOLD, 16));
        destinations.setMargin(new Insets(5,5,5,5));
        destinations.addActionListener(this);
        //p2.add(destinations);
        
        CheckPackage = new JButton("Check Package");
        CheckPackage.setBounds(0, 170,300,40);
        CheckPackage.setBackground(new Color(0,0,102));
        CheckPackage.setForeground(new Color(255,254,145));
        CheckPackage.setFont(new Font("Tahuma", Font.BOLD, 16));
        CheckPackage.setMargin(new Insets(5,5,5,5));
        CheckPackage.addActionListener(this);
        //p2.add(CheckPackage);
        
        BookPackage = new JButton("Book Package");
        BookPackage.setBounds(0, 210,300,40);
        BookPackage.setBackground(new Color(0,0,102));
        BookPackage.setForeground(new Color(255,254,145));
        BookPackage.setFont(new Font("Tahuma", Font.BOLD, 16));
        BookPackage.setMargin(new Insets(5,5,5,5));
        BookPackage.addActionListener(this);
        //p2.add(BookPackage);
        
        ViewPackage = new JButton("View Booked Package");
        ViewPackage.setBounds(0, 250,300,40);
        ViewPackage.setBackground(new Color(0,0,102));
        ViewPackage.setForeground(new Color(255,254,145));
        ViewPackage.setFont(new Font("Tahuma", Font.BOLD, 16));
        ViewPackage.setMargin(new Insets(5,5,5,5));
        ViewPackage.addActionListener(this);
        //p2.add(ViewPackage);
        
        ViewHotels = new JButton("View Hotels");
        ViewHotels.setBounds(0, 290,300,40);
        ViewHotels.setBackground(new Color(0,0,102));
        ViewHotels.setForeground(new Color(255,254,145));
        ViewHotels.setFont(new Font("Tahuma", Font.BOLD, 16));
        ViewHotels.setMargin(new Insets(5,5,5,5));
        ViewHotels.addActionListener(this);
        //p2.add(ViewHotels);
        
        BookHotel = new JButton("Book Hotel");
        BookHotel.setBounds(0, 330,300,40);
        BookHotel.setBackground(new Color(0,0,102));
        BookHotel.setForeground(new Color(255,254,145));
        BookHotel.setFont(new Font("Tahuma", Font.BOLD, 16));
        BookHotel.setMargin(new Insets(5,5,5,5));
        BookHotel.addActionListener(this);
        //p2.add(BookHotel);
        
        ViewBookedHotels = new JButton("View Booked Hotels");
        ViewBookedHotels.setBounds(0,370,300,40);
        ViewBookedHotels.setBackground(new Color(0,0,102));
        ViewBookedHotels.setForeground(new Color(255,254,145));
        ViewBookedHotels.setFont(new Font("Tahuma", Font.BOLD, 16));
        ViewBookedHotels.setMargin(new Insets(5,5,5,5));
        ViewBookedHotels.addActionListener(this);
        //p2.add(ViewBookedHotels);
        
//        Payment = new JButton("Payment");
//        Payment.setBounds(0,410,300,40);
//        Payment.setBackground(new Color(0,0,102));
//        Payment.setForeground(new Color(255,254,145));
//        Payment.setFont(new Font("Tahuma", Font.BOLD, 16));
//        Payment.setMargin(new Insets(5,5,5,5));
//        Payment.addActionListener(this);
        
        //p2.add(Payment);
        
        instruction = new JButton("Some Instructions");
        instruction.setBounds(0, 450,300,40);
        instruction.setBackground(new Color(0,0,102));
        instruction.setForeground(new Color(255,254,145));
        instruction.setFont(new Font("Tahuma", Font.BOLD, 16));
        instruction.setMargin(new Insets(5,5,5,5));
        instruction.addActionListener(this);
        //p2.add(instrc);
        
        Feedback = new JButton("Feedback");
        Feedback.setBounds(0, 490,300,40);
        Feedback.setBackground(new Color(0,0,102));
        Feedback.setForeground(new Color(255,254,145));
        Feedback.setFont(new Font("Tahuma", Font.BOLD, 16));
        Feedback.setMargin(new Insets(5,5,5,5));
        Feedback.addActionListener(this);
        //p2.add(Feedback);
        
        abt = new JButton("About");
        abt.setBounds(0, 490,300,40);
        abt.setBackground(new Color(0,0,102));
        abt.setForeground(new Color(255,254,145));
        abt.setFont(new Font("Tahuma", Font.BOLD, 16));
        abt.setMargin(new Insets(5,5,5,5));
        abt.addActionListener(this);
        //p2.add(abt);
        
        logout = new JButton("Log-out");
        logout.setBounds(0, 530,300,40);
        logout.setBackground(new Color(0,0,102));
        logout.setForeground(new Color(255,254,145));
        logout.setFont(new Font("Tahuma", Font.BOLD, 16));
        logout.setMargin(new Insets(5,5,5,5));
        logout.addActionListener(this);
        //p2.add(abt);
//        Paymenthotel = new JButton("Payment hotel");
//        Paymenthotel.setBounds(0,410,300,40);
//        Paymenthotel.setBackground(new Color(0,0,102));
//        Paymenthotel.setForeground(new Color(255,254,145));
//        Paymenthotel.setFont(new Font("Tahuma", Font.BOLD, 16));
//        Paymenthotel.setMargin(new Insets(5,5,5,5));
//        Paymenthotel.addActionListener(this);
        
        
        p2.add(addyourdetails);
        p2.add(updateyourdetails);
        p2.add(destinations);
        p2.add(CheckPackage);
        p2.add(BookPackage);
        p2.add(ViewPackage);
        p2.add(ViewHotels);
        p2.add(BookHotel);
        p2.add(ViewBookedHotels);
        p2.add(instruction);
        p2.add(Feedback);
        p2.add(abt);
        p2.add(deleteyourdetails);
        p2.add(logout);
        

//         JScrollPane scrollPane = new JScrollPane(p2);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//        scrollPane.setBounds(0, 65, 300, 900);
//        add(scrollPane);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== addyourdetails )
        {
            new AddCustomer(username);
        }
        else if(ae.getSource()== updateyourdetails )
        {
            new UpdateCustomer(username);
        }
        else if(ae.getSource()== deleteyourdetails )
        {
            new ViewCustomer(username);
        }
        else if(ae.getSource()== destinations )
        {
            new Destination();
        }
        else if(ae.getSource()== CheckPackage )
        {
            new CheckPackage();
        }
        else if(ae.getSource()== BookPackage )
        {
            new BookPackage(username);
        }
        else if(ae.getSource()== ViewPackage )
        {
            new ViewPackage(username);
        }
        else if(ae.getSource()== ViewHotels )
        {
            new ViewHotel();
        }
        else if(ae.getSource()== BookHotel )
        {
            new BookHotel(username);
        }
        else if(ae.getSource()== ViewBookedHotels )
        {
            new ViewBookedHotel(username);
        }
        else if(ae.getSource()== Feedback )
        {
            new TravelFeedbackForm(username);
        }
        else if(ae.getSource()== instruction )
        {
           new Instructions();
        }
        else if(ae.getSource()== logout )
        {
            dispose(); // Close the current window (Home screen)
            new Logout(); // Open the login screen
        }
        else if(ae.getSource()== abt )
        {
           new About();
        }
//        else if(ae.getSource()==Paymenthotel)
//        {
//            new Paymenthotel(username);
//        }    
//        else if(ae.getSource()==Payment)
//        {
//            new Payment(username);
//        }    
//        
    }    
    public static void main(String args[]){
        
        new Home("");
    }
        
}

