package electricity.billing.system;

import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
;
import java.awt.event.MouseListener;

public class PayBill extends JFrame implements ActionListener,KeyListener{
     JLabel l1,l2,l3,l4,l5,l6;
     JTextField jt1,jt3,jt4;
     JButton paybill;
     Choice month,paymentOption;
     JPanel panel;
    public PayBill()  {
         
        setSize(700,600);
        setLocation(150,90);
        panel= new JPanel();
        panel.setLayout(new GridLayout(7,2,45,45));
        
        l1= new JLabel("Meter No :");
        jt1 = new JTextField();
        l1.setFont(new Font("Senserif", Font.PLAIN, 18));
        
        panel.add(l1);
        panel.add(jt1);
       l2= new JLabel("Select Month : ");
       month= new Choice();
       month.add("January");
       month.add("February");
       month.add("March");
       month.add("April");
       month.add("May");
       month.add("June");
       month.add("July");
       month.add("August");
       month.add("September");
       month.add("October");
       month.add("November");
       month.add("December");
     


        l2.setFont(new Font("Senserif", Font.PLAIN, 18));
        panel.add(l2);
        panel.add(month);
        l3 = new JLabel("Enter Consumed Units :");
        jt3= new JTextField();
        l3.setFont(new Font("Senserif", Font.PLAIN, 18));
        panel.add(l3);
        panel.add(jt3);
        l4 = new JLabel("Total Amount :");
        jt4 = new JTextField();
        l4.setFont(new Font("Senserif", Font.PLAIN, 18));
        panel.add(l4);
        panel.add(jt4);
        l5 = new JLabel("Choose Payment Option");
        l5.setFont(new Font("Senserif", Font.PLAIN, 18));
        paymentOption = new Choice();
        paymentOption.add("Cash");
        paymentOption.add("ATM Card");
        paymentOption.add("Debit Card");
        paymentOption.add("Paytm");
        paymentOption.add("Phone Pay");
        panel.add(l5);
        panel.add(paymentOption);
        paybill= new JButton("Pay Bill");
        paybill.setFont(new Font("Senserif",Font.BOLD,12));
        paybill.setBackground(Color.black);
        paybill.setForeground(Color.white);
        paybill.setBounds(350,550,100,100);
        paybill.addActionListener(this);
        
        panel.add(paybill);
         jt3.addKeyListener(this);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(panel,"Center");
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/image/billing.png"));
            Image i= icon.getImage().getScaledInstance(200,200 ,Image.SCALE_DEFAULT);
            ImageIcon icon2= new ImageIcon(i);
            l6 = new JLabel(icon2);
            add(l6,"West");
            
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(Color.WHITE);
        setVisible(true);
      }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==paybill) {
            String meterNo= jt1.getText();
            String Month= month.getSelectedItem();
            String unit1= jt3.getText();
            int unit= Integer.parseInt(unit1);
            String amount1= jt4.getText();
            int amount= Integer.parseInt(amount1);
            String paymentType= paymentOption.getSelectedItem();
            String query="insert into bill values('"+meterNo+"', '"+Month+"','"+unit+"','"+paymentType+"','"+amount+"')";
            try {
                dbConenction connection = new dbConenction();
              
                int i= connection.s.executeUpdate(query);
                if (i>0) {
                     
                JOptionPane.showMessageDialog(null, "Payment done successfully!!!!");
                jt1.setText("");
                jt3.setText("");
                jt4.setText("");
                }
                else{  
                 
                JOptionPane.showMessageDialog(null, "Payment Failed!!!!","Error",JOptionPane.ERROR_MESSAGE);
                
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    
    }
    
    public static void main(String[]args){
    
       new PayBill();
        
       }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       }

    @Override
    public void keyReleased(KeyEvent e) {
         String Unit=jt3.getText();
       int netunit= Integer.parseInt(Unit)*7;
       jt4.setText(String.valueOf(netunit));
    }


  
}
