import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class transfer_money{
    public double exchange = 0;
    public boolean more;
    transfer_money(double exchange,boolean more){
        this.exchange = exchange;
        this.more = more;
    }
    public double exchange(double cash){
        if(more){
            return cash/exchange;
        }else{
            return cash*exchange;
        }
    }
}
class test extends JFrame implements ActionListener {
    public static JTextField input = new JTextField();
    public static JTextField canadian = new JTextField();
    test(){
        input.setSize(100,100);
        canadian.setSize(100,100);
        input.setHorizontalAlignment(JTextField.RIGHT);
        canadian.setHorizontalAlignment(JTextField.RIGHT);
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Convert US Dollars to Canadian Dollars");
        frame.setSize(500,160);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2,2));
        JPanel panel2 = new JPanel(new GridLayout(1,2));
        JPanel panel3 = new JPanel(new GridLayout(2,1));
        JPanel panel4 = new JPanel(new GridLayout(2,1));
        JPanel panel5 = new JPanel(new GridLayout(1,2));
        frame.add(panel2,BorderLayout.CENTER);
        frame.add(panel5,BorderLayout.SOUTH);
        panel2.add(panel3, BorderLayout.WEST);
        panel2.add(panel4, BorderLayout.CENTER);
        JLabel us = new JLabel("US Dollars");
        JLabel canada = new JLabel("Canadian Dollars");

        panel3.add(us,BorderLayout.CENTER);
        panel3.add(canada,BorderLayout.SOUTH);


        canadian.setEditable(false);

        panel4.add(input,BorderLayout.CENTER);
        panel4.add(canadian,BorderLayout.SOUTH);

        JButton convert = new JButton("convert");
        convert.setBounds(370,10,110,30);
        panel5.add(convert,BorderLayout.EAST);
        convert.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double money = Double.parseDouble(input.getText());
        transfer_money t1 = new transfer_money(1.5,false);
        canadian.setText(Double.toString(t1.exchange(money)));
    }
}
public class Main {
    public static void main(String[] args) {
        test t1 = new test();
    }
}