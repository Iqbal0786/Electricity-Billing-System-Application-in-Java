
package electricity.billing.system;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class New_Customer extends JFrame implements ActionListener{
        JLabel l1,l2,l3,l4,l5,l6,l7,l8;
        JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
        JButton button1,button2;
        New_Customer(){
            setSize(650,600);
            setLocation(200,50);
           // setDefaultCloseOperation(EXIT_ON_CLOSE);
            JPanel panel= new JPanel();
            panel.setLayout(new GridLayout(9,2,30,30));
            panel.setBackground(Color.WHITE);
            l1= new JLabel("Name");
            jt1= new JTextField();
            panel.add(l1);
            panel.add(jt1);
            l2 = new JLabel("Meter NO.");
            jt2 = new JTextField();
            panel.add(l2);
            panel.add(jt2);
            l3 = new JLabel("Address");
            jt3= new JTextField();
            panel.add(l3);
            panel.add(jt3);
            l4= new JLabel("State");
            jt4 = new JTextField();
            panel.add(l4);
            panel.add(jt4);
            l5 = new JLabel("City");
            jt5 = new JTextField();
            panel.add(l5);
            panel.add(jt5);
            l6 = new JLabel("Phone NO.");
            jt6 = new JTextField();
            panel.add(l6);
            panel.add(jt6);
            l7 = new JLabel("Email");
            jt7 = new JTextField();
            panel.add(l7);
            panel.add(jt7);
            button1= new JButton("Submit");
            button2 = new JButton("Cancel");
            button1.addActionListener(this);
            button2.addActionListener(this);
            button1.setBackground(Color.BLACK);
            button1.setForeground(Color.WHITE);
            button2.setBackground(Color.BLACK);
            button2.setForeground(Color.WHITE);
            panel.add(button1);
            panel.add(button2);
            setLayout(new BorderLayout());
            add(panel,"Center");
            ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/image/new customer 2.png"));
            Image i= icon.getImage().getScaledInstance(210,210 ,Image.SCALE_DEFAULT);
            ImageIcon icon2= new ImageIcon(i);
            l8 = new JLabel(icon2);
            add(l8,"West");
            
            
            getContentPane().setBackground(Color.WHITE);
            add(panel);
           
            setVisible(true);
        
         }
        public void actionPerformed(ActionEvent ae){
            
            
            if (ae.getSource()==button1) {
              String name1=jt1.getText();
              String meterNo1= jt2.getText();
              String address1= jt3.getText();
              String state1= jt4.getText();
              String  city1= jt5.getText();
              String phone1=jt6.getText();
              String email1=jt7.getText();
              String querry="insert into New_Customer values ('"+name1+"','"+meterNo1+"','"+address1+"','"+state1+"','"+city1+"','"+phone1+"','"+email1+"')";
              Validation v= new Validation();
              //Adding Validation 
            if (!v.nameValidate(name1)) {
                JOptionPane.showMessageDialog(null,"Please Enter a valid Name","Error",JOptionPane.ERROR_MESSAGE);
               
                }
            else  if (!v.meternoValidate(meterNo1)) {
                JOptionPane.showMessageDialog(null,"Please Enter Meter Number Only in Integer Number","Error",JOptionPane.ERROR_MESSAGE);
                
                }
             else  if (!v.addressValidate(address1)) {
                JOptionPane.showMessageDialog(null,"Please Enter a valid Address only using English letters","Error",JOptionPane.ERROR_MESSAGE);
                
                }
             else  if (!v.cityValidate(city1)) {
                JOptionPane.showMessageDialog(null,"Please Enter a correct City name","Error",JOptionPane.ERROR_MESSAGE);
                
                }
             else  if (!v.emailValidate(email1)) {
                JOptionPane.showMessageDialog(null,"Please Enter a Valid Email Address!!","Error",JOptionPane.ERROR_MESSAGE);
                
                }
             else  if (!v.phoneValidate(phone1)) {
                JOptionPane.showMessageDialog(null,"Make sure phone number must be  in Integer and upto 10 digits only","Error",JOptionPane.ERROR_MESSAGE);
                
                }
             else{
              try{
              dbConenction conenction= new dbConenction();
              
               conenction.s.executeUpdate(querry);
               JOptionPane.showMessageDialog(null, "Registerd Successfully!!!!");
               
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");
                jt6.setText("");
                jt7.setText("");
                       
                  
                  
                 
            
               }catch(Exception e){
               
                 e.printStackTrace();
                 }
             
               }
                
                 
             }
                 else   {
                  //emptying all the textfields      
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");
                jt6.setText("");
                jt7.setText("");
                   }
            
              }
        
                  
           
    
        
        public static void main(String[]args){
        
        new New_Customer();
          }
}
