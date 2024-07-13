package travel.management.system;

//import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public final class CheckPackage extends JFrame{
    public static void main(String[] args) {
      new CheckPackage().setVisible(true);
    }

    CheckPackage() {    
      setBounds(480, 100, 850, 600); 
      setVisible(true);
      String[] package1 = new String[]{"package1.jpg","GOLD PACKAGE 1","Paradise Explorer Package","Location-GOA","5 days and 4 Nights", "Stroll at famous beaches in Goa", "Shopping at Tibetan Market", "Welcome drinks on Arrival", "Seek blessings from temples of South Goa", "Goa bliss retreat", "Rs 15000 only"};
      String[] package2 = new String[]{"rajasthan1.jpg","GOLD PACKAGE 2","Heritage Marvel Package","Location-RAJASTHAN","5 days and 4 Nights", "Explore the major attractions", "Half Day City Tour", "Jaipur sightseeing", "Daily Buffet", "Royal rajasthan expedition","Rs 15000 only"};
      String[] package3 = new String[]{"darjeeling1.jpg","SILVER PACKAGE 1","Mountain Majesty Package","Location-DARJEELING","5 days and 4 Nights", "Visit tea gardens", "Visit ghoom monastery,japanese temple", "Night Safari", "Waterfall Trip", "Mountain bliss retreat", "Rs 13000 only"};
      String[] package4 = new String[]{"AND1.jpg","SILVER PACKAGE 2","Tropical Escape Package","Location-ANDAMAN & NICOBAR","5 days and 4 Nights", "Cellular Jail", "Light and sound show", "Havelock island", "Natural Rock Bridge","Seaside serenity", "Rs 13000 only"};
      String[] package5 = new String[]{"SHIMLA1.jpg","BRONZE PACKAGE 1","Serenity Bliss Package","Location-SHIMLA","5 days and 4 Nights", "Visit mall road", "Christ Church", "Climbing on Jakhoo Hill", "Adventure Explorer","Snowy shimla getaway", "Rs 12000 only"};
      String[] package6 = new String[]{"MANALI.jpg","BRONZE PACKAGE 2","Adventure Quest Package","Location-MANALI","5 days and 4 Nights", "Enjoy a sightseeing tour", "Excursion to Rohtang Pass", "WItness the beauty of Solang valley", "Adventure Activities", "Majestic Manali Adventure", "Rs 12000 only"};
      
      JTabbedPane tabbedPane = new JTabbedPane();
      JPanel p1 = createPackage(package1);
      tabbedPane.addTab("Package 1", null, p1);
      
      JPanel p2 = createPackage(package2);
      tabbedPane.addTab("Package 2", null, p2);
      
      JPanel p3 = createPackage(package3);
      tabbedPane.addTab("Package 3", null, p3);
      
      JPanel p4 = createPackage(package4);
      tabbedPane.addTab("Package 4", null, p4);
      
      JPanel p5 = createPackage(package5);
      tabbedPane.addTab("Package 5", null, p5);
      
      JPanel p6 = createPackage(package6);
      tabbedPane.addTab("Package 6", null, p6);
      
      add(tabbedPane, BorderLayout.CENTER);    
   }
    
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
      
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[0]));
        Image i3 = i1.getImage().getScaledInstance(550, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400,0,450,420);
        p1.add(l1);

        JLabel lblName = new JLabel(pack[1]);
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 5, 350, 53);
        p1.add(lblName);

        JLabel l3 = new JLabel(pack[2]);
        l3.setForeground(Color.RED);
        l3.setBounds(35, 70, 400, 14);
        p1.add(l3);

        JLabel lblId = new JLabel(pack[3]);
        lblId.setForeground(Color.BLUE);
        lblId.setBounds(35, 110, 400, 14);
        p1.add(lblId);

        JLabel l2 = new JLabel(pack[4]);
        l2.setForeground(Color.RED);
        l2.setBounds(35, 150, 400, 14);
        p1.add(l2);

        JLabel lblName_1 = new JLabel(pack[5]);
        lblName_1.setForeground(Color.BLUE);
        lblName_1.setBounds(35, 190, 400, 14);
        p1.add(lblName_1);

        JLabel lblGender = new JLabel(pack[6]);
        lblGender.setForeground(Color.RED);
        lblGender.setBounds(35, 230, 400, 14);
        p1.add(lblGender);

        JLabel lblCountry = new JLabel(pack[7]);
        lblCountry.setForeground(Color.BLUE);
        lblCountry.setBounds(35, 270, 400, 14);
        p1.add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel(pack[8]);
        lblReserveRoomNumber.setForeground(Color.RED);
        lblReserveRoomNumber.setBounds(35, 295, 400, 35);
        p1.add(lblReserveRoomNumber);

        JLabel l11 = new JLabel(pack[9]);
        l11.setForeground(Color.BLUE);
        l11.setBounds(35, 330, 400, 30);
        p1.add(l11);

        JLabel lblDeposite = new JLabel(pack[10]);
        lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblDeposite.setBounds(35, 370, 400, 40);
        p1.add(lblDeposite);
        
//        JLabel la1 = new JLabel(pack[11]);
//        la1.setForeground(Color.RED);
//       la1.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
//       la1.setBounds(600, 460, 400, 40);
//        p1.add(la1);
        setVisible(true);
        return p1;
        
    }
}