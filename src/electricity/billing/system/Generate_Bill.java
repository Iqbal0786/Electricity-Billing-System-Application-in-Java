package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Generate_Bill extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextArea jt;
    Choice choice1, choice2;
    JPanel panel;
    JButton generate,print;

    Generate_Bill() {
        super("Generate Bill");
        setSize(500, 700);
        setLocation(200, 50);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panel = new JPanel();

        l2 = new JLabel("Choose Meter No");
        l3 = new JLabel("Choose Month");
        choice1 = new Choice();
        choice2 = new Choice();
        jt = new JTextArea(50, 15);
        jt.setEditable(false);
        jt.setFont(new Font("SENSERIF", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(jt);
        generate = new JButton("Generate Bill");
        generate.addActionListener(this);
        generate.setBounds(250,700,100,100);
        print= new JButton("Print Bill");
        print.setBounds(300,700,100,100);
        print.addActionListener(this);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Senserif",Font.BOLD,14));

        choice1.add("1001");
        choice1.add("1002");
        choice1.add("1003");
        choice1.add("1004");
        choice1.add("1005");
        choice1.add("1006");
        choice1.add("1007");
        choice1.add("1008");
        choice2.add("January");
        choice2.add("February");
        choice2.add("March");
        choice2.add("April");
        choice2.add("May");
        choice2.add("June");
        choice2.add("July");
        choice2.add("August");
        choice2.add("September");
        choice2.add("October");
        choice2.add("November");
        choice2.add("December");

        panel.add(l2);
        panel.add(choice1);
        panel.add(l3);
        panel.add(choice2);
        panel.add(print);
       
        add(panel, "North");
        add(generate,"South");
       
        add(scrollPane, "Center");

        setVisible(true);

    }

    public static void main(String[] args) {

        new Generate_Bill();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generate) {
            try {
                dbConenction connection = new dbConenction();
                String month = choice2.getSelectedItem();
                String meterNo=choice1.getSelectedItem();
                jt.setText("\tRelience Eletric Power Limited\n      Bill for the Current Month of  '" + month + "',2020\n\n\n");
                ResultSet rs = connection.s.executeQuery("select* from new_customer where Meter_No='"+meterNo+"' ");
                if (rs.next()) {
                    jt.append("\n    Consumer Name :" + rs.getString("Name"));
                    jt.append("\n    Meter No        " + rs.getString("Meter_No"));
                    jt.append("\n    Address :       " + rs.getString("Address"));
                    jt.append("\n    State Name :     " + rs.getString("State"));
                    jt.append("\n    City       :      " + rs.getString("City"));
                    jt.append("\n    PhoneNumber :           " + rs.getString("Phone_No"));
                    jt.append("\n    Email Id    :       " + rs.getString("Email"));
                    jt.append("\n -----------------------------------------------------------");
                    jt.append("\n");
                }
                 else{
                        
                    JOptionPane.showMessageDialog(null, "Record Not Found ??");
                    this.setVisible(false);
                    }

                rs = connection.s.executeQuery("select* from tax");
                if (rs.next()) {

                    jt.append("\n   Meter Location   :          " + rs.getString("Meter_Location"));
                    jt.append("\n   Meter Type       :          " + rs.getString("Meter_Type"));
                    jt.append("\n   Phase Code       :          " + rs.getString("PhaseCode"));
                    jt.append("\n   Bill Type        :          " + rs.getString("BillType"));
                    jt.append("\n   Meter Rent       :          " + rs.getString("MeterRent"));
                    jt.append("\n   MCB Rent         :          " + rs.getString("MCB_Rent"));
                    jt.append("\n   Service Rent     :          " + rs.getString("Service_Rent"));
                    jt.append("\n ----------------------------------------------------------------");
                    jt.append("\n");
                }
                 else{
                        
                    JOptionPane.showMessageDialog(null, "Record Not Found ??");
                    }
                rs = connection.s.executeQuery("select* from bill");
                if (rs.next()) {
                    jt.append("\n   Meter No             :       " + rs.getString("Meter_No"));
                    jt.append("\n   Current Month        :       " + rs.getString("Month"));
                    jt.append("\n   Consumed Units       :       " + rs.getString("Units"));
                    jt.append("\n   Payment Mode         :       "+ rs.getString("Payment_Mode"));
                    jt.append("\n   Total Payable Amount :       " + rs.getString("Total_Amount"));
                    jt.append("\n  ---------------------------------------------------------");
                } else {

                    JOptionPane.showMessageDialog(null, "Record Not Found ??");
                }

            } catch (Exception e1) {

                e1.printStackTrace();
            }

        }
        else{
        try{
           jt.print();
        
           }
          catch(Exception e1){
             e1.printStackTrace();
           }
          
          }
    }
}
