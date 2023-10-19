
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
/**
 *
 * @author student
 */
class Hangman extends JFrame{
    public Hangman(){
        add(new DrawArea());
    }
    class DrawArea extends JPanel{
        private Timer timer = new Timer(1,new Listener());
        int x = 0 ;
        int y = 0 ;
        int a;
        boolean c = true;
        DrawArea(){
            timer.start();
            setFocusable(c);
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawArc(20, 220, 80, 40, 0, 180);
            g.drawLine(20 + 40, 220, 20 + 40, 20);
            g.drawLine(20 + 40, 20, 20 + 40 + 100, 20);

            if( 160-x == 200 || 160+y == 120) {
                a = 1 ;
            }
            if (160-x == 120 || 160+y == 200) {
                a = 0 ;}
            int radius = 20;
            g.drawLine(20 + 40 + 100, 20, 20 + 40 + 100 - x, 40);
            g.drawOval(20 + 40 - x + 100 - radius, 40, 2 * radius, 2 * radius);
            g.drawLine(20 + 40 - x + 100 - (int)(radius *Math.cos(Math.toRadians(45))),40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),20 + 40 + 100 - 60 - x*2, 40 + radius + 60);
            g.drawLine(20 + 40 - x + 100 + (int)(radius *Math.cos(Math.toRadians(45))),40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),20 + 40 + 100 + 60 - x*2, 40 + radius + 60);
            g.drawLine(20 + 40 - x + 100, 40 + 2* radius,20 + 40 + 100 - x*2, 40 + radius + 80);
            g.drawLine(20 + 40 -2* x + 100, 40 + radius + 80, 20 + 40 + 100 - 40-x*3,40 + radius + 80 + 40);
            g.drawLine(20 + 40 -2* x + 100, 40 + radius + 80, 20 + 40 + 100 + 40-x*3,40 + radius + 80 + 40);
            if (a == 0 ){
                x--;
                y--;
            }
            else{
                x++;
                y++;
            }

        }
    }
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            repaint();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hangman frame = new Hangman();
        frame.setTitle("Hangman");
        frame.setSize(1200,1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}