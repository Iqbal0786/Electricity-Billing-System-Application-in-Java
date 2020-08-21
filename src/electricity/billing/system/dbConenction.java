
package electricity.billing.system;
import java.sql.*;

public class dbConenction {
    Connection c;
    Statement s;
    public dbConenction(){
      try{
       Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql:///electricity_billing_soft","root","");
       s=c.createStatement();
      }
      catch(Exception e){
        e.printStackTrace();
      }
    
    }
}
