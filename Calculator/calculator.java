import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math.*;
import java.util.Enumeration;

public class calculator implements ActionListener {
    public create_gui calculator_gui;
    public double dec = 0;
    public Queue<Double> decimal = new LinkedList<>();
    public Queue<String> operator = new LinkedList<>();
    calculator(create_gui cal) {
        this.calculator_gui = cal;
        calculator_gui.add_field_text("0","box",-15,0,500,60);
        calculator_gui.textfieldDictionary.get("box").setHorizontalAlignment(JTextField.RIGHT);
        calculator_gui.textfieldDictionary.get("box").setEditable(false);
        calculator_gui.textfieldDictionary.get("box").setBackground(Color.white);
        calculator_gui.add_panel("panel_b",6,4,2,2);
        calculator_gui.add_label(" "," ","1","panel_b");
        calculator_gui.add_label(" "," ","2","panel_b");
        calculator_gui.add_label(" "," ","3","panel_b");
        calculator_gui.add_label(" "," ","4","panel_b");


        calculator_gui.add_button("√","√","panel_b");
        calculator_gui.add_button("x^2","x^2","panel_b");
        calculator_gui.add_button("±","±","panel_b");
        calculator_gui.add_button("C","C","panel_b");
        calculator_gui.buttonDictionary.get("C").setForeground(Color.red);
        calculator_gui.add_button("7","7","panel_b");
        calculator_gui.add_button("8","8","panel_b");
        calculator_gui.add_button("9","9","panel_b");
        calculator_gui.add_button("+","+","panel_b");
        calculator_gui.add_button("6","6","panel_b");
        calculator_gui.add_button("5","5","panel_b");
        calculator_gui.add_button("4","4","panel_b");
        calculator_gui.add_button("-","-","panel_b");
        calculator_gui.add_button("1","1","panel_b");
        calculator_gui.add_button("2","2","panel_b");
        calculator_gui.add_button("3","3","panel_b");
        calculator_gui.add_button("*","*","panel_b");
        calculator_gui.add_button("0","0","panel_b");
        calculator_gui.add_button(".",".","panel_b");
        calculator_gui.add_button("=","=","panel_b");
        calculator_gui.add_button("/","/","panel_b");
        Enumeration<String> keys = calculator_gui.buttonDictionary.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            calculator_gui.buttonDictionary.get(key).addActionListener(this);
        }
        calculator_gui.set_jframe_visible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == calculator_gui.buttonDictionary.get("C")){
            dec = 0;
        }else if(obj == calculator_gui.buttonDictionary.get("0")) {
            dec *= 10;
        }else if(obj == calculator_gui.buttonDictionary.get("1")) {
            dec *= 10;
            dec += 1;
        }else if(obj == calculator_gui.buttonDictionary.get("2")) {
            dec *= 10;
            dec += 2;
        }else if(obj == calculator_gui.buttonDictionary.get("3")) {
            dec *= 10;
            dec += 3;
        }else if(obj == calculator_gui.buttonDictionary.get("4")) {
            dec *= 10;
            dec += 4;
        }else if(obj == calculator_gui.buttonDictionary.get("5")) {
            dec *= 10;
            dec += 5;
        }else if(obj == calculator_gui.buttonDictionary.get("6")) {
            dec *= 10;
            dec += 6;
        }else if(obj == calculator_gui.buttonDictionary.get("7")) {
            dec *= 10;
            dec += 7;
        }else if(obj == calculator_gui.buttonDictionary.get("8")) {
            dec *= 10;
            dec += 8;
        }else if(obj == calculator_gui.buttonDictionary.get("9")) {
            dec *= 10;
            dec += 9;
        }else if(obj == calculator_gui.buttonDictionary.get("x^2")) {
            dec *= dec;
        }else if(obj == calculator_gui.buttonDictionary.get("√")) {
            dec = Math.sqrt(dec);
        }else if(obj == calculator_gui.buttonDictionary.get("±")) {
            dec *= -1;
        }else if(obj == calculator_gui.buttonDictionary.get("+")) {
            decimal.add(dec);
            dec=0;
            operator.add("+");
        }else if(obj == calculator_gui.buttonDictionary.get("-")) {
            decimal.add(dec);
            dec=0;
            operator.add("-");
        }else if(obj == calculator_gui.buttonDictionary.get("*")) {
            decimal.add(dec);
            dec=0;
            operator.add("*");
        }else if(obj == calculator_gui.buttonDictionary.get("/")) {
            decimal.add(dec);
            dec=0;
            operator.add("/");
        }else if(obj == calculator_gui.buttonDictionary.get("=")) {

            decimal.add(dec);
            dec=0;
            while(!decimal.isEmpty()){
                dec = decimal.remove();
                if(operator.peek() == "+"){
                    dec = dec + decimal.remove();
                }else if(operator.peek() == "-"){
                    dec = dec - decimal.remove();
                }else if(operator.peek() == "*"){
                    dec = dec * decimal.remove();
                }else if(operator.peek() == "/"){
                    dec = dec / decimal.remove();
                }operator.remove();
            }
        }
        String text = Double.toString(dec);
        calculator_gui.textfieldDictionary.get("box").setText(text);
        System.out.println(Double.toString(dec));
    }
}
