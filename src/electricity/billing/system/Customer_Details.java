
package electricity.billing.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author lenovo
 */
public class Customer_Details extends JFrame implements ActionListener{
    JTable t1;
    JButton b1;
    String x[]={"Emp Name","Meter No","Address","State","City","Email","Phone"};
    int i=0,j=0;
    String y[][]=new String[100][8];
    Customer_Details(){
     super("Customers Details");
        setBounds(200,110,900,650);
        try{
            
          dbConenction  connection =new dbConenction();
            String s1="select * from new_customer";
            ResultSet rs=connection.s.executeQuery(s1);
            while(rs.next()){
              y[i][j++]=rs.getString("Name");
              y[i][j++]=rs.getString("Meter_No");
              y[i][j++]=rs.getString("Address");
              y[i][j++]=rs.getString("State");
              y[i][j++]=rs.getString("City");
              y[i][j++]=rs.getString("Phone_No");
              y[i][j++]=rs.getString("Email");
              
              i++;
              j=0;
            }
            t1=new JTable(y,x);
        }catch(Exception e){
            e.printStackTrace();
        }
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        b1=new JButton("Print");
        add(b1,"South");
        b1.addActionListener(this);
        JScrollPane sp=new JScrollPane(t1);
        add(sp);
        
        getContentPane().setBackground(Color.white);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            t1.print();
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Customer_Details().setVisible(true);
    }
}