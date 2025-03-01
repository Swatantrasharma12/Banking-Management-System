
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Image;
//import javax.swing.*;
//import java.awt.event.*;
//import java.sql.ResultSet;
//import java.util.*;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,cashwithdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setForeground(Color.white);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(210,300,700,35);
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashwithdrawl = new JButton("Rs 200");
        cashwithdrawl.setBounds(335,415,150,30);
        cashwithdrawl.addActionListener(this);
        image.add(cashwithdrawl);
        
        fastcash = new JButton("Rs 500");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 1000");
        ministatement.setBounds(335,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 2000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(335,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Back");
        exit.setBounds(335,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where formno = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficien Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}


//public class FastCash extends JFrame implements ActionListener {
//
//	JButton deposit, withdrawl,one, five, thousand, two, fivethousand, tenthousand, back;
//	
//	String pinnumber;
//	FastCash(String pinnumber){
//		this.pinnumber = pinnumber;
//		setLayout(null);
//		
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
//		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel image = new JLabel(i3);
//		image.setBounds(0, 0, 900, 900);
//		add(image);
//		
//		// Show on upper side of the image
//		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
//		text.setBounds(210, 300, 700, 35);
//		text.setForeground(Color.WHITE);
//		text.setFont(new Font("System", Font.BOLD, 16)); 
//		image.add(text);
//		
//		one = new JButton("Rs 100");
//		one.setBounds(170, 415, 150, 30);
//		one.addActionListener(this);
//		image.add(one);
//		
//		five = new JButton("Rs 500");
//		five.setBounds(355, 415, 150, 30);
//		five.addActionListener(this);
//		image.add(five);
//		
//		thousand = new JButton("Rs 1000");
//		thousand.setBounds(170, 450, 150, 30);
//		thousand.addActionListener(this);
//		image.add(thousand);
//		
//		two = new JButton("Rs 2000");
//		two.setBounds(355, 450, 150, 30);
//		two.addActionListener(this);
//		image.add(two);
//		
//		fivethousand = new JButton("Rs 5000");
//		fivethousand.setBounds(170, 485, 150, 30);
//		fivethousand.addActionListener(this);
//		image.add(fivethousand);
//		
//		tenthousand = new JButton("Rs 10000");
//		tenthousand.setBounds(355, 485, 150, 30);
//		tenthousand.addActionListener(this);
//		image.add(tenthousand);
//		
//		back = new JButton("BACK");
//		back.setBounds(355, 520, 150, 30);
//		back.addActionListener(this);
//		image.add(back);
//		//About frame 
//		setSize(900, 900);
//		setLocation(300, 0);
//		setUndecorated(true);
//		setVisible(true);
//	}
//	public static void main(String[] args) {
//         
//		new FastCash("");
//	}
//	public void actionPerformed(ActionEvent ae) {
//		  if(ae.getSource() == back) {
//                 setVisible(false);
//                 new Transactions(pinnumber).setVisible(true);
//		}else{
//			  String amount = ((JButton)ae.getSource()).getText().substring(3); // only wants digit not Rs word
//		      Conn c = new Conn();
//		      try {
//		    	  ResultSet rs = c.s.executeQuery("select * from bank where formno = '"+pinnumber+"'");
//		          int balance = 0;
//		          while(rs.next()) {
//		        	  if(rs.getString("type").equals("Deposit")) {
//		        		  balance += Integer.parseInt(rs.getString("amount"));//Integer.parseInt is using to convert string into integer 
//		        	  }else {
//		        		  balance -= Integer.parseInt(rs.getString("amount"));
//		        	  }
//		          }
//		          
//		          if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
//		        	  JOptionPane.showMessageDialog(null, "Insufficient Balance");
//		              return;
//		          }
//		            Date date = new Date();
//		            String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
//		            c.s.execute(query);
//			    JOptionPane.showMessageDialog(null, "Rs"+ amount + "Debited Sucessfully");
//
//		            setVisible(false);
//		            new Transactions(pinnumber).setVisible(true);
//		            
//		      }catch(Exception e) {
//		    	  System.out.println(e);
//		      }
//		  }
//	}
//
//}