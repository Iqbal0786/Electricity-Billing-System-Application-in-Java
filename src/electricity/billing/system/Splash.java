
package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
public class Splash {
    
    public static void main(String[]args){
    frame f= new frame();
    f.setVisible(true);
    int i;
    int x=1;
        for (i=2; i<=600; i+=4,x+=1) {
            
            f.setLocation(750- ((i+x)/2), 400- (i/2));
            f.setSize(i+x,i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
    
}
 class frame extends JFrame implements Runnable{
     Thread t;
    frame(){
      super("Electricty Billing System");
        setLayout(new FlowLayout());
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/image/electricity.jpg"));
        Image i2= i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
         add(l1);
           t= new Thread(this);
           t.start();
   }

    @Override
    public void run() {
       
        try{
           Thread.sleep(7000);
          
           
           Login l= new Login();
           l.setVisible(true);
           this.setVisible(false);
        }
        catch(Exception e){
          
            e.printStackTrace();
        }
    }

}