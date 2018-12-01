package tilerummy.GUI;

import java.awt.Color;

import javax.swing.JButton;  
import javax.swing.JFrame;  
public class JButtonDemo 
{
      JButtonDemo()
      {  
            JFrame frame=new JFrame();     
            JButton b1 = new JButton("OK");
            JButton b2 = new JButton("Quit");
            b1.setBounds(50,50,90, 50); 
            b2.setBounds(150,50,90,50); 
            b1.setOpaque(true);
            b2.setOpaque(true);
            b1.setBackground(Color.black);
            b2.setBackground(Color.green);
            frame.add(b1);  
            frame.add(b2);
            frame.setSize(300,200);  
        
            frame.setLayout(null);  
            frame.setVisible(true);  
                  
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       }  
       public static void main(String[] args)
       {  
             new JButtonDemo();  
       }  
}
