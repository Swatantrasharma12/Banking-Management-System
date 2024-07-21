
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male,female,married,unmarried,other;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("Application no. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(240,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page No.1: Personal Details...");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,130,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial",Font.BOLD,15));
        nameTextField.setBounds(300,130,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,180,150,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Arial",Font.BOLD,15));
        fnameTextField.setBounds(300,180,400,30);
        add(fnameTextField);
        
        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,230,150,30);
        add(DOB);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,230,400,30);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,280,150,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,280,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(420,280,120,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,330,150,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial",Font.BOLD,15));
        emailTextField.setBounds(300,330,400,30);
        add(emailTextField);
        
        JLabel martial = new JLabel("Martial Status:");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(100,380,150,30);
        add(martial);
        
        married = new JRadioButton("Married");
        married.setBounds(300,380,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(430,380,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other = new JRadioButton("Others");
        other.setBounds(570,380,120,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup martialGroup = new ButtonGroup();
        martialGroup.add(married);
        martialGroup.add(unmarried);
        martialGroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,430,150,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial",Font.BOLD,15));
        addressTextField.setBounds(300,430,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,480,150,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial",Font.BOLD,15));
        cityTextField.setBounds(300,480,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,530,150,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial",Font.BOLD,15));
        stateTextField.setBounds(300,530,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,580,150,30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Arial",Font.BOLD,15));
        pincodeTextField.setBounds(300,580,400,30);
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setFont(new Font("Arial",Font.BOLD,15));
        next.setBounds(620, 650, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(200, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    String formno = "" + random;
    String name = nameTextField.getText();
    String fname = fnameTextField.getText();
    String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
    String gender = null;
    if(male.isSelected()){
        gender = "Male";
    }else if(female.isSelected()){
        gender = "Female";
    }
    String email = emailTextField.getText();
    String martial = null;
    if(married.isSelected()){
        martial = "Married";
    }else if(unmarried.isSelected()){
        martial = "Unmarried";
    }else if(other.isSelected()){
        martial = "Other";
    }
    
    String address = addressTextField.getText();
    String city = cityTextField.getText();
    String pin = pincodeTextField.getText();
    String state = stateTextField.getText();
    
    try{
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is required");
        }else{
            Conn c = new Conn();
            String query = "insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data inserted successfully");
            
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }   
    } catch(Exception e){
        System.out.println(e);
    }
}

    
    public static void main(String args[]){
        new SignupOne();
    }
    
}
