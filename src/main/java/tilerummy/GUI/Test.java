package tilerummy.GUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Test {

    public static void main(String[] args) {

        JFrame frm = new JFrame();
        frm.setSize(300, 300);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);

        JPanel pnl = new JPanel();
        pnl.setLayout(new BorderLayout());
        frm.getContentPane().add(pnl);
        
        JButton btn = new JButton("Button");
        //btn.setPreferredSize(new Dimension(300, 100));
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);
        btn.setFont(font);
        pnl.add(btn, BorderLayout.NORTH);

    }
}