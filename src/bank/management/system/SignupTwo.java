
package bank.management.system;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField pan,adhar;
    
    JRadioButton syes ,sno,eyes,eno;
    JButton next;
    JComboBox religion,category,income,education,occupation;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
    
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
       
        
        JLabel additionalDetails = new JLabel("Page3: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD ,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD ,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
         
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD ,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
         String valcategory[] = {"General","OBC","SC","ST"};
         category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD ,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
         income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);
        
       
         JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway",Font.BOLD ,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD ,22));
        email.setBounds(100,315,200,30);
        add(email);
        
         String educationValues[] = {"Non-Graduste","Graduate","Post-Graduate","Doctrate","Others"};
         education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);
        
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD ,22));
        marital.setBounds(100,390,200,30);
        add(marital);
        
         String occupationValues[] = {"Salried","Self-Employed","Business","Student","Retired","Others"};
         occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD ,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        
        JLabel city = new JLabel("Adhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD ,22));
        city.setBounds(100,490,200,30);
        add(city);
        
         adhar = new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,14));
        adhar.setBounds(300,490,400,30);
        add(adhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD ,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(450,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
         sno = new JRadioButton("No");
        sno.setBounds(600,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);
       
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD ,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
         eyes = new JRadioButton("Yes");
        eyes.setBounds(450,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
         eno = new JRadioButton("No");
        eno.setBounds(600,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);
        
         
         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
        
}
    public void actionPerformed(ActionEvent ae){
       
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        } else if (sno.isSelected()){
            seniorcitizen ="No";
        }
           //String email= emailTextField.getText();
           String existingaccount = null;
           if(eyes.isSelected()){
               existingaccount = "Yes";
             }else if (eno.isSelected()){
                 existingaccount = "No";
             }
           String span =pan.getText();
           String sadhar = adhar.getText();
          
           
           try{
               
                 Conn c =new Conn(); 
                 String query = "insert into signuptwo values( '"+formno+"','"+sreligion+"' ,'"+scategory+"','"+sincome+"','"+seducation+"' ,'"+soccupation+"','"+span+"', '"+sadhar+"','"+seniorcitizen+"','"+existingaccount+"' )";
               c.s.executeUpdate(query);  
               //signup3 object
               setVisible(false);
               new SignupThree(formno).setVisible(true);
               
    }
           catch (Exception e)
           {System.out.println(e);
           }
    } 
    public static void main(String args[]){
        new SignupTwo("");
    }
}

    

