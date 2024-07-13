package travel.management.system;


import java.awt.*;
import java.awt.EventQueue;


import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class BookPackage extends JFrame {
	private JPanel contentPane;
        JTextField t1;
        Choice c1;
        // Add these declarations at the beginning of your class
JLabel lblBookingDate, lblReturnDate;
JTextField bookingDateTextField;
	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        BookPackage frame = new BookPackage("");
                        frame.setVisible(true);
                    } catch (Exception e) {
                    }
                });
	}

	public BookPackage(String username) {
		setBounds(420, 220, 1100, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(450,50,700,300);
                add(la1);
		
		JLabel lblName = new JLabel("BOOK PACKAGE");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 5, 300, 53);
		contentPane.add(lblName);
                
                JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 50, 200, 14);
		contentPane.add(la2);
                
                JLabel l1 = new JLabel(username);
		l1.setBounds(271, 50, 200, 14);
		contentPane.add(l1);
                
                JLabel lblId = new JLabel("Select Package :");
		lblId.setBounds(35, 80, 200, 14);
		contentPane.add(lblId);
                
                c1 = new Choice();
                c1.add("Gold Package 1");
                c1.add("Gold Package 2");
                c1.add("Silver Package 1");
                c1.add("Silver Package 2");
                c1.add("Bronze Package 1");
                c1.add("Bronze Package 2");
                c1.setBounds(271, 80, 150, 30);
                add(c1);
                
                JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 200, 200, 14);
		contentPane.add(la3);
                
                t1 = new JTextField();
                t1.setText("0");
		t1.setBounds(271, 200, 200, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 230, 200, 14);
		contentPane.add(lbl1);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 230, 200, 14);
		contentPane.add(l2);
		
		JLabel lbl2 = new JLabel("Number :");
		lbl2.setBounds(35, 260, 200, 14);
		contentPane.add(lbl2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 260, 200, 14);
		contentPane.add(l3);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(35, 290, 200, 14);
		contentPane.add(lbl3);
                
                JLabel l4 = new JLabel();
		l4.setBounds(271, 290, 200, 14);
		contentPane.add(l4);
                
                // Add this code in the constructor, after setting up other components
lblBookingDate = new JLabel("Booking Date:");
lblBookingDate.setBounds(35, 320, 200, 14);
contentPane.add(lblBookingDate);

bookingDateTextField = new JTextField();
bookingDateTextField.setBounds(271, 320, 150, 20);
contentPane.add(bookingDateTextField);

lblReturnDate = new JLabel("Return Date:");
lblReturnDate.setBounds(35, 350, 200, 14);
contentPane.add(lblReturnDate);

JLabel l6 = new JLabel();
		l6.setBounds(271, 350, 200, 14);
              l6.setForeground(Color.BLACK);
		contentPane.add(l6);

		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 380, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l5 = new JLabel();
		l5.setBounds(271, 380, 200, 14);
                l5.setForeground(Color.RED);
		contentPane.add(l5);
                
                try{
                    Conn c = new Conn();
                    try (ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'")) {
                        while(rs.next()){
                            l2.setText(rs.getString("id_type"));
                            l3.setText(rs.getString("number"));
                            l4.setText(rs.getString("phone"));
                            
                        }
                    }
                }catch(Exception e){}
                
                JButton b1 = new JButton("Check Price");
		b1.addActionListener((ActionEvent e) -> {
                    String p = c1.getSelectedItem();
                    int cost = 0;
                    if(p.equals("Gold Package 1")) {
                        cost += 15000;
                    }
                    if(p.equals("Gold Package 2")) {
                        cost += 15000;
                    }if(p.equals("Silver Package 1")){
                        cost += 13000;
                    }if(p.equals("Silver Package 2")){
                        cost += 13000;
                    }else if(p.equals("Bronze Package 1")){
                        cost += 12000;
                    }else if(p.equals("Bronze Package 2")){
                        cost += 12000;
                    }
                    
                    cost *= Integer.parseInt(t1.getText());
                    l5.setText("Rs "+cost);
                });
		b1.setBounds(50, 410, 120, 30);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		
	JButton btnNewButton = new JButton("Book");
	btnNewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Conn c = new Conn();
                        try {
                            String packageName = c1.getSelectedItem();
                            String totalPersons = t1.getText();
                            String idType = l2.getText();
                            String number = l3.getText();
                            String phone = l4.getText();
                            String totalPrice = l5.getText();
                            String userEnteredBookingDate = bookingDateTextField.getText();
                           
             
                            
                            // Parse the user-entered booking date
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date parsedDate = dateFormat.parse(userEnteredBookingDate);
                            java.sql.Date bookingDate = new java.sql.Date(parsedDate.getTime());
                            
                            // Calculate return date (booking date + 5 days)
                            java.sql.Date returnDate = new java.sql.Date(parsedDate.getTime() + (5 * 24 * 60 * 60 * 1000));
                            
                            String q1 = "insert into bookPackage values('" + username + "', '" + packageName + "', '"
                                    + totalPersons + "', '" + idType + "', '" + number + "', '" + phone + "', '" + totalPrice + "', '"
                                    + bookingDate + "', '" + returnDate + "')";
                            
                            c.s.executeUpdate(q1);
                            
                            // Display booking date and return date
                           // lblBookingDate.setText("Booking Date: " + bookingDate);
                            l6.setText(" " + returnDate);
                           
                            Payment payment = new Payment("");

                    // Display payment window
                            payment.setVisible(true);
                            
                           // JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                           // setVisible(false);
                            
                            
                        } catch (Exception ee) {
                            System.out.println(ee.getMessage());
                        }       }
                });

		btnNewButton.setBounds(200, 410, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener((ActionEvent e) -> {
                    setVisible(false);
                }); 
		btnExit.setBounds(350, 410, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
                setVisible(true);
	}
}