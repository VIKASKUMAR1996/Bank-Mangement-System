
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
   String cardnumber;
    MiniStatement(String cardnumber ){
        
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        //mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login  where cardnumber = '"+cardnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+ rs.getString("cardnumber").substring(12));
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM (\n" +"   SELECT * FROM bank where cardnumber = '"+cardnumber+"' ORDER BY  date DESC LIMIT 16 \n" +")Var1\n" +"   ORDER BY date ASC ");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount") +"<br><br><html>");
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
         
        int balance = 0;
            try{
                Conn c = new Conn();
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
            text.setForeground(Color.black);
            text.setBounds(40,680,400,30);
            add(text);
        
        mini.setBounds(20,100,400,600);
        
        
        
        setSize(400,800);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    public static void main(String args[]){
    new MiniStatement("");
    }
}
