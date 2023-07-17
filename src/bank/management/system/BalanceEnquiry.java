
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class BalanceEnquiry extends JFrame implements ActionListener {
    String cardnumber;
    JButton back;
    BalanceEnquiry(String cardnumber){
        
        this.cardnumber =cardnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton ("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where cardnumber = '"+cardnumber+"'");
                
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e){
                        System.out.println(e);
                        }
            
            JLabel text = new JLabel("Your Current Account Balance is RS "+balance);
            text.setForeground(Color.white);
            text.setBounds(170,300,400,30);
            image.add(text);
           
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(cardnumber).setVisible(true);
    }
    
    public static void main (String args[]){
        new BalanceEnquiry("");
    }
}
