
package bank.management.system;
import java.sql.*;
public class Conn {
 Connection c;
 Statement s;
 public Conn(){
     try {
         //Class.forName(com.mysql.cj.jdbc.Driver);
         c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Vikas#1996");
         s = c.createStatement();
     }
     catch(Exception e){
        System.out.println(e);
     }
 }
 
}
