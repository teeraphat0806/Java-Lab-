import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main {

    public static void main(String[] args) {
        create_gui cal = new create_gui(500,400,"Simple Caculator");
        cal.setResizable(false);
        calculator calculators = new calculator(cal);
    }
}