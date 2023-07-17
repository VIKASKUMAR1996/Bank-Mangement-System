
package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw , back;
    String pinnumber,cardnumber;
    Withdrawl(String cardnumber){
        
        this.cardnumber = cardnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter The Amount You Want To Withdrawl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD ,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font ("Raleway" , Font.BOLD ,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton ("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton ("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter The Amount You Want To Withdraw");
            }else {
               try{ Conn conn = new Conn();
               
               
               
               
               ResultSet rs = conn.s.executeQuery("select * from bank where cardnumber = '"+cardnumber+"' ");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource()!= back && balance < Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
              
                String query = "insert into bank values('"+cardnumber+"' , '"+date+"','Withdrawl','"+number+"') ";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+ " Withdraw Successfully");
                amount.setText("");
               }catch(Exception e){
                   System.out.println(e);
               }
            }
        }else if (ae.getSource()==back){
            setVisible(false);
            new Transactions(cardnumber).setVisible(true);
        }
    }
    public static void main (String args[]){
        new Withdrawl("");
    }
    
}
