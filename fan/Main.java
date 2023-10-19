import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DrawArcs extends JFrame implements ActionListener {
    public static JButton stop = new JButton("STOP");
    public static JButton n1 = new JButton("1");
    public static JButton n2 = new JButton("2");
    public static JButton n3 = new JButton("3");
    public static JButton n4 = new JButton("4");
    public static ArcsPanel arc = new ArcsPanel();
    public DrawArcs() {
        add(arc);
        stop.addActionListener(this);
        n1.addActionListener(this);
        n2.addActionListener(this);
        n3.addActionListener(this);
        n4.addActionListener(this);
        setTitle("DrawArcs");
    }
    /** Main method */
    public static void main(String[] args) {
        DrawArcs frame = new DrawArcs();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 300);
        frame.setVisible(true);

        JPanel panel =new JPanel();
        panel.add(stop);
        panel.add(n1);
        panel.add(n2);
        panel.add(n3);
        panel.add(n4);
        frame.add(panel, BorderLayout.SOUTH);
    }

    @Override /** Handle the action event */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == n1){
            arc.speed = 1;
        }else if(e.getSource() == n2){
            arc.speed = 2;
        }else if(e.getSource() == n3){
            arc.speed = 3;
        }else if(e.getSource() == n4){
            arc.speed = 4;
        }else if(e.getSource() == stop){
            arc.speed = 0;
        }
    }

}
// The class for drawing arcs on a panel
class ArcsPanel extends JPanel {
    public int delay = 10;
    public int speed = 0;
    public int speeds=0;
    public Timer timer = new Timer(delay, new TimerListener());
    ArcsPanel(){
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
        int x = xCenter - radius;
        int y = yCenter - radius;
        g.fillArc(x, y, 2 * radius, 2 * radius, speeds, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, speeds+90, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, speeds+180, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, speeds+270, 30);
    }
    private class TimerListener implements ActionListener {
        @Override /** Handle the action event */
        public void actionPerformed(ActionEvent e) {
            speeds += speed;
            repaint();
        }
    }
}