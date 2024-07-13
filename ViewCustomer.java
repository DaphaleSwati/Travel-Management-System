package travel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back, delete;
    String username;

    // Constructor
    ViewCustomer(String username) {
        this.username = username;
        setBounds(450, 180, 850, 625);
        setLayout(null);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(600, 350, 100, 25);
        back.addActionListener(this);
        add(back);

        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(200, 350, 100, 25);
        delete.addActionListener(this);
        add(delete);

        // Load and display images
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 400, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(600, 400, 600, 200);
        add(image1);

        // Labels for customer details
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel Labelusername = new JLabel("");
        Labelusername.setBounds(220,50,150,25);
        add(Labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,110,150,25);
        add(lblid);
        
        JLabel Labelid = new JLabel("");
        Labelid.setBounds(220,110,150,25);
        add(Labelid);
        
        JLabel lblno = new JLabel("Number");
        lblno.setBounds(30,170,150,25);
        add(lblno);
        
        JLabel Labelno = new JLabel("");
        Labelno.setBounds(220,170,150,25);
        add(Labelno);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);
        
        JLabel Labelname = new JLabel("");
        Labelname.setBounds(220,230,150,25);
        add(Labelname);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,290,150,25);
        add(lblGender);
        
        JLabel LabelGender = new JLabel("");
        LabelGender.setBounds(220,290,150,25);
        add(LabelGender);
        
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(500,50,150,25);
        add(lblCountry);
        
        JLabel LabelCountry = new JLabel("");
        LabelCountry.setBounds(690,50,150,25);
        add(LabelCountry);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(500,110,150,25);
        add(lblAddress);
        
        JLabel LabelAddress = new JLabel("");
        LabelAddress.setBounds(690,110,150,25);
        add(LabelAddress);
        
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(500,170,150,25);
        add(lblPhone);
        
        JLabel LabelPhone = new JLabel("");
        LabelPhone.setBounds(690,170,150,25);
        add(LabelPhone);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(480,230,150,25);
        add(lblEmail);
        
        JLabel LabelEmail = new JLabel("");
        LabelEmail.setBounds(670,230,150,25);
        add(LabelEmail);
        
  

        try {
            // Database query to retrieve customer details
            Conn conn = new Conn();
            String query = "select * from customer where username ='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                Labelusername.setText(rs.getString("username"));
                Labelid.setText(rs.getString("id_type"));
                Labelno.setText(rs.getString("number"));
                Labelname.setText(rs.getString("name"));
                LabelGender.setText(rs.getString("gender"));
                LabelCountry.setText(rs.getString("country"));
                LabelPhone.setText(rs.getString("phone"));
                LabelAddress.setText(rs.getString("address"));
                LabelEmail.setText(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    // Action performed when buttons are clicked
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == delete) {
            try {
                // Database operations to delete customer data
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username='" + username + "'");
                c.s.executeUpdate("delete from customer where username='" + username + "'");
               // c.s.executeUpdate("delete from bookpackage where username='" + username + "'");
               // c.s.executeUpdate("delete from bookhotel where username='" + username + "'");
               setVisible(false);
                JOptionPane.showMessageDialog(this, "Data deleted Successfully");
                
                new Signup().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ViewCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        new ViewCustomer("");
    }
}
