
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton Yes,No,Yes1,No1;
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        setTitle("New Account Apllication Form - Page 2");
        
        JLabel additionalDetails = new JLabel("Page No.2: Additional Details...");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel YReligion = new JLabel("Religion:");
        YReligion.setFont(new Font("Raleway",Font.BOLD,20));
        YReligion.setBounds(100,130,100,30);
        add(YReligion);
        
        String valReligion[] = {"Hindu" ,"Muslim","Sikh","Christian","Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,130,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel YCategory = new JLabel("Category:");
        YCategory.setFont(new Font("Raleway",Font.BOLD,20));
        YCategory.setBounds(100,180,150,30);
        add(YCategory);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setBackground(Color.white);
        category.setBounds(300,180,400,30);
        add(category);
        
        JLabel YIncome = new JLabel("Income:");
        YIncome.setFont(new Font("Raleway",Font.BOLD,20));
        YIncome.setBounds(100,230,150,30);
        add(YIncome);
        
        String incomeCategory[] = {"Null", "< 1,50,00", "<2,50,000", "<3,50,000", "<4,50,000"};
        income = new JComboBox(incomeCategory);
        income.setBackground(Color.white);
        income.setBounds(300,230,400,30);
        add(income);
    
        JLabel YEducation = new JLabel("Educational:");
        YEducation.setFont(new Font("Raleway",Font.BOLD,20));
        YEducation.setBounds(100,280,150,30);
        add(YEducation);
        
        JLabel YQualification = new JLabel("Qualification:");
        YQualification.setFont(new Font("Raleway",Font.BOLD,20));
        YQualification.setBounds(100,305,150,30);
        add(YQualification);
        
        String educationCategory[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Ph.d"};
        education = new JComboBox(educationCategory);
        education.setBackground(Color.white);
        education.setBounds(300,305,400,30);
        add(education);
        
        
        JLabel YOccupation = new JLabel("Occupation:");
        YOccupation.setFont(new Font("Raleway",Font.BOLD,20));
        YOccupation.setBounds(100,380,150,30);
        add(YOccupation);
        
        String occupationCategory[] = {"Student", "Self-Employed", "Bussiness", "Retired", "Others"};
        occupation = new JComboBox(occupationCategory);
        occupation.setBackground(Color.white);
        occupation.setBounds(300,380,400,30);
        add(occupation);
        
        JLabel YPANno = new JLabel("PAN No:");
        YPANno.setFont(new Font("Raleway",Font.BOLD,20));
        YPANno.setBounds(100,430,150,30);
        add(YPANno);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Arial",Font.BOLD,15));
        panTextField.setBounds(300,430,400,30);
        add(panTextField);
        
        JLabel YAdharno = new JLabel("Adhar No:");
        YAdharno.setFont(new Font("Raleway",Font.BOLD,20));
        YAdharno.setBounds(100,480,150,30);
        add(YAdharno);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Arial",Font.BOLD,15));
        aadharTextField.setBounds(300,480,400,30);
        add(aadharTextField);
        
        JLabel YSenior = new JLabel("Senior Citizen:");
        YSenior.setFont(new Font("Raleway",Font.BOLD,20));
        YSenior.setBounds(100,530,250,30);
        add(YSenior);
        
        Yes = new JRadioButton("Yes");
        Yes.setBackground(Color.white);
        Yes.setBounds(300,530,60,30);
        add(Yes);
        
        No = new JRadioButton("No");
        No.setBackground(Color.white);
        No.setBounds(400,530,60,30);
        add(No);
        
        ButtonGroup SeniorCitizen = new ButtonGroup();
        SeniorCitizen.add(Yes);
        SeniorCitizen.add(No);
        
        JLabel YExisting = new JLabel("Existing Account:");
        YExisting.setFont(new Font("Raleway",Font.BOLD,20));
        YExisting.setBounds(100,580,250,30);
        add(YExisting);
        
        Yes1 = new JRadioButton("Yes");
        Yes1.setBackground(Color.white);
        Yes1.setBounds(300,580,60,30);
        add(Yes1);
        
        No1 = new JRadioButton("No");
        No1.setBackground(Color.white);
        No1.setBounds(400,580,60,30);
        add(No1);
        
        ButtonGroup ExistingAccount = new ButtonGroup();
        ExistingAccount.add(Yes1);
        ExistingAccount.add(No1);
        
        
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
    
    public void actionPerformed(ActionEvent ae) {
    String sreligion = (String) religion.getSelectedItem();
    String scategory = (String) category.getSelectedItem();
    String sincome = (String) income.getSelectedItem();
    String seducation = (String) education.getSelectedItem();
    String soccupation = (String) occupation.getSelectedItem();
    String span = panTextField.getText();
    String saadhar = aadharTextField.getText();
    String SeniorCitizen = null;
    if (Yes.isSelected()) {
        SeniorCitizen = "Yes";
    } else if (No.isSelected()) {
        SeniorCitizen = "No";
    }
    String ExistingAccount = null;
    if (Yes1.isSelected()) {
        ExistingAccount = "Yes";
    } else if (No1.isSelected()) {
        ExistingAccount = "No";
    }

    try {
        Conn c = new Conn();
        String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+SeniorCitizen+"','"+ExistingAccount+"')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Data inserted successfully");
        
        setVisible(false);
        new SignupThree(formno).setVisible(true);
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }

    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
    
}
