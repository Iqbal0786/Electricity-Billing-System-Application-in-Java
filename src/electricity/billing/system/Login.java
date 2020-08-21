
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
import sun.security.ec.point.ProjectivePoint;
import sun.security.util.math.IntegerModuloP;

public class Login extends JFrame implements ActionListener {
     JLabel l1,l2,l3;
     JTextField jt;
     JPasswordField jpass;
     JButton login,cancel;
     JPanel p1,p2,p3,p4;
    Login(){
        l1 = new JLabel("User Name :");
        l2= new JLabel("Password :");
       jt= new JTextField(15);
       jpass= new JPasswordField(15);
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/image/loginout.png"));
       Image i2= i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       login= new JButton("Loging",new ImageIcon(i2));
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/image/cancel.png"));
       Image i5= i4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
       ImageIcon i6= new ImageIcon(i5);
       cancel= new JButton("Cancel", new ImageIcon(i5));
       
       login.addActionListener(this);
       cancel.addActionListener(this);
       ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/image/employee copy2.png"));
       Image i8= i7.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT);
       ImageIcon i9 = new ImageIcon(i8);
       l3= new JLabel(i9);
        setLayout(new BorderLayout());
        p1= new JPanel();
        p2= new JPanel();
        p3= new JPanel();
        p4= new JPanel();
        add(l3, BorderLayout.WEST);
        p1.add(l1);
        p1.add(jt);
         p1.add(l2);
         p1.add(jpass);
       
       
        
        add(p1, BorderLayout.CENTER);
        p2.add(login);
        p2.add(cancel);
        add(p2, BorderLayout.SOUTH);
        p1.setBackground(Color.WHITE);
        p2.setBackground(Color.WHITE);
        setSize(450,250);
        setLocation(500,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE );
        setVisible(true);
    
      }
    
    
   
    public void actionPerformed(ActionEvent e) {
        try {
              dbConenction conenction= new dbConenction();
        String username= jt.getText();
        char [] pass1= jpass.getPassword();
        String password= new String(pass1);
        String query="select * from login  where user_Name='"+username+"' and  password='"+password+"'";
        ResultSet rs= conenction.s.executeQuery(query);
        if(rs.next()){
         new Home().setVisible(true);
         this.setVisible(false);
        
           } 
        else{
          JOptionPane.showMessageDialog(null, "Login Error!!!! Please Enter Correct UserId and Password");
          setVisible(false);
          }
        }
        catch (Exception ee) {
            ee.printStackTrace();
              }
       }
    
    
    public static void main(String[] args) {
         new Login().setVisible(true);
    }
    
    
    
    
}
