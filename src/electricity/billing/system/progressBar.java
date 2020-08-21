
package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.*;


public class progressBar extends JFrame{

    public progressBar()  {
        setSize(700,550);
        setLocation(200,90);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panel= new JPanel();
         panel.setBackground(Color.WHITE);
        JProgressBar progressBar= new JProgressBar(60,58);
        progressBar.setBackground(Color.red);
        
        panel.add(progressBar);
        add(panel,"South");
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new progressBar();
    }
}
