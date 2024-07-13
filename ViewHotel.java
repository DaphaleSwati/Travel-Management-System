
package travel.management.system;

//import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public final class ViewHotel extends JFrame{
    public static void main(String[] args) {
      new ViewHotel().setVisible(true);
    }

    ViewHotel() {    
      setBounds(480, 100, 850, 600);
      setVisible(true);
      String[] package1 = new String[]{"hotel3.jpg","JW Marriott Hotel","Luxurious stay with exciting activities","Daily buffet breakfast","24/7 room services", "Evening turndown services", "Lawish swimming pool", "Free Wi-Fi facility", "Cost per Day-400", "Food Charges-500", "AC Charges-600"};
      String[] package2 = new String[]{"hotel2.jpg","Four Seasons Hotel","Breathtaking views and exceptional services","24/7 Front Desk","Queen-size bed", "Deluxe Room", "Fitness Center with modern equipment", "Serenity Spa offering a range of treatments", "Cost per Day-500", "Food Charges-600", "AC Charges-700"};
      
      JTabbedPane tabbedPane = new JTabbedPane();
      JPanel p1 = createPackage(package1);
      tabbedPane.addTab("Hotel 1", null, p1);
      
      JPanel p2 = createPackage(package2);
      tabbedPane.addTab("Hotel 2", null, p2);
      
      
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
        lblReserveRoomNumber.setBounds(35, 290, 400, 35);
        p1.add(lblReserveRoomNumber);
        
         JLabel l11 = new JLabel(pack[9]);
        l11.setForeground(Color.BLUE);
        l11.setBounds(35, 330, 400, 30);
        p1.add(l11);
        
         JLabel l12 = new JLabel(pack[10]);
        l12.setForeground(Color.RED);
        l12.setBounds(35, 360, 400, 40);
        p1.add(l12);

        setVisible(true);
        return p1;
        
    }
}