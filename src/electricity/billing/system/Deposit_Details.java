 
package electricity.billing.system;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Deposit_Details extends JFrame implements ActionListener{
    JTable t1;
    JButton b1;
    String x[]={"Meter No","Month","Units","Payment Mode","Total Amount"};
    int i=0,j=0;
    String y[][]=new String[100][5];
    Deposit_Details(){
     super("Deposit Details");
     setBounds(200,110,900,650);
        try{
            
          dbConenction  connection =new dbConenction();
            String s1="select * from bill";
            ResultSet rs=connection.s.executeQuery(s1);
            while(rs.next()){
              y[i][j++]=rs.getString("Meter_No");
              y[i][j++]=rs.getString("Month");
              y[i][j++]=rs.getString("Units");
              y[i][j++]=rs.getString("Payment_Mode");
              y[i][j++]=rs.getString("Total_Amount");
           
              
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
        setVisible(true);
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
        new Deposit_Details();
    
      
        }
    
}
