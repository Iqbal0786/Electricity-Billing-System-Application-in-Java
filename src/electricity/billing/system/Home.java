

package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
    JMenuItem newcostomer,customerdetails,depositdetails,paybill,Calculatebill,lastbill,generatebill,notepad,calculator,browser;
    
    Home(){
        //adding background image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/image/powerplant image.jpg"));
        Image i2= i1.getImage().getScaledInstance(1800, 850, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        add(label);
        
        // creating JMenuBar 
        JMenuBar menuBar= new JMenuBar();
        JMenu master= new JMenu("Master");
         newcostomer= new JMenuItem("New Customer");
          newcostomer.addActionListener(this);
        master.setFont(new Font("Times New Roman", Font.PLAIN, 16));
       
         //code for generatig short key
         newcostomer.setMnemonic('N');
         newcostomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
         newcostomer.setBackground(Color.WHITE);
         master.add(newcostomer);
          customerdetails= new JMenuItem("Customer Details");
         customerdetails.addActionListener(this);
         customerdetails.setMnemonic('D');
         customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
         customerdetails.setBackground(Color.WHITE);
         master.add(customerdetails);
           depositdetails= new JMenuItem("Deposit Details");
         depositdetails.addActionListener(this);
         depositdetails.setMnemonic('C');
         depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
         depositdetails.setBackground(Color.WHITE);
        
         master.add(depositdetails);
         menuBar.add(master);
         
         // user menu
         JMenu user= new JMenu("User");
          paybill= new JMenuItem("PayBill");
         paybill.setBackground(Color.WHITE);
         paybill.addActionListener(this);
         user.add(paybill);
          Calculatebill= new JMenuItem("Calculate Bill");
         Calculatebill.setBackground(Color.WHITE);
         Calculatebill.addActionListener(this);
         user.add(Calculatebill);
          lastbill= new JMenuItem("Last Bill");
         lastbill.setBackground(Color.WHITE);
         lastbill.addActionListener(this);
         user.add(lastbill);
         
         menuBar.add(user);
         user.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         //report menu
         JMenu report = new JMenu("Report");
         report.setFont(new Font("Times New Roman", Font.PLAIN, 16));
          generatebill= new JMenuItem("Generate Bill");
         generatebill.setBackground(Color.WHITE);
         generatebill.addActionListener(this);
         report.add(generatebill);
         menuBar.add(report);
         
         //utility menu
         JMenu utility= new JMenu("Utility");
         utility.setFont(new Font("Times New Roman", Font.PLAIN, 16));
          notepad= new JMenuItem("Open NotePad");
         notepad.setBackground(Color.WHITE);
         notepad.addActionListener(this);
         utility.add(notepad);
          calculator= new JMenuItem("Open Calculator");
         calculator.setBackground(Color.WHITE);
         calculator.addActionListener(this);
         utility.add(calculator);
          browser= new JMenuItem("Open Browser");
         browser.setBackground(Color.WHITE);
         browser.addActionListener(this);
         utility.add(browser);
         menuBar.add(utility);
         
         //Exit menu
         JMenu exit1= new JMenu("Exit");
         menuBar.add(exit1);
         exit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               System.exit(0);
            }
        });
         exit1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         
        setJMenuBar(menuBar);
        setSize(1920,1030);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
      }
    
    
    public void actionPerformed(ActionEvent ae){
                   if (ae.getSource()==newcostomer) {
                       
                       new New_Customer().setVisible(true);
                       
                       
                     }
                   else if (ae.getSource()==customerdetails) {
                     
                       new Customer_Details().setVisible(true);
                       
                      }
                   else if (ae.getSource()== generatebill) {
                       
                       new Generate_Bill().setVisible(true);
                       
                          }
                   else if (ae.getSource()== paybill) {
                       
                       new PayBill().setVisible(true);
                       
                          }
                    else if (ae.getSource()== depositdetails) {
                       
                       new Deposit_Details().setVisible(true);
                       
                          }
                     else if (ae.getSource()== Calculatebill) {
                       
                       
                          }
                      else if (ae.getSource()== lastbill) {
                       
                       new PayBill().setVisible(true);
                       
                          }
                   
                   else  if (ae.getSource()==notepad) {
                   
                      try {
                      Runtime.getRuntime().exec("notepad.exe");
                      
                       } 
                  
                  catch (Exception e) {
                      
                      
                               }
                     }
                    else  if (ae.getSource()==calculator) {
                   
                      try {
                      Runtime.getRuntime().exec("calc.exe");
                      
                       } 
                  
                  catch (Exception e) {
                      
                      
                               }
                     }
                    else  if (ae.getSource()==browser) {
                   
                      try {
                      Runtime.getRuntime().exec("C:\\Program Files \\Mozilla Firefox\firefox.exe");
                      
                       } 
                  
                  catch (Exception e) {
                      
                      
                               }
                     }
                   
              }
    
    public static void main(String[] args) {
        new Home().setVisible(true);
    }
}
