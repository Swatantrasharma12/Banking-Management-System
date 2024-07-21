
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        
        setLayout(null);
        setTitle("Automated Teller Machine");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // to fetch the image
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // set the height and width the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3); // to set image
        label.setBounds(70,10,100,100); // set the dimensions of image(dimension left, dimension top, Image width, Image height)
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM"); // Set the label
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);
        
        JLabel cardno = new JLabel("Card No.:"); // set the card no.
        cardno.setBounds(120,150,150,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);
        
        cardTextField = new JTextField(); // card label
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:"); // set pin 
        pin.setBounds(120,220,150,40);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);
        
        pinTextField = new JPasswordField(); // pin label
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("Sign in");
        login.setBounds(300,270,100,30);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("Clear");
        clear.setBounds(450,270,100,30);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("Sign up");
        signup.setBounds(300,330,250,30);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white); // set background color
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(200,200);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }else if(ae.getSource() == login){
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect card number and pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == signup){
            
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
