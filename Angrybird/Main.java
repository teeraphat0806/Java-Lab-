import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.File;


class game extends JFrame implements ActionListener {
    public JFrame frame = new JFrame();
    public panel panels = new panel(600,600,this);
    public JTextArea y_axis = new JTextArea();
    public JTextArea shooting_speed = new JTextArea();
    public JTextArea Angle = new JTextArea();
    JTextField scores = new JTextField();
    game() throws IOException {
        frame.setLayout(null);
        frame.setTitle("Angry Bird Game");

        // TextArea
        y_axis.setSize(100,20);
        y_axis.setBounds(200,420,170,20);
        shooting_speed.setSize(100,20);
        shooting_speed.setBounds(200,450,170,20);
        Angle.setSize(100,20);
        Angle.setBounds(200,480,170,20);

        frame.add(y_axis);
        frame.add(shooting_speed);
        frame.add(Angle);

        // Label
        Label scene_label = new Label();
        scene_label.setText("SCENE 1: GALAXY");
        scene_label.setSize(200,40);
        scene_label.setFont( new Font("Courier", Font.PLAIN, 20));
        scene_label.setBounds(55,45,200,40);

        Label score = new Label();
        score.setText("SCORE");
        score.setSize(100,40);
        score.setFont(new Font("Courier", Font.PLAIN, 20));
        score.setBounds(380,45,80,40);

        Label bird = new Label();
        bird.setText("Bird Position in y-axis                                                               m");
        bird.setSize(400,20);
        bird.setBounds(70,420,400,20);

        Label shooting_s = new Label();
        shooting_s.setText("Shooting speed                                                                        m/s");
        shooting_s.setSize(400,20);
        shooting_s.setBounds(70,450,400,20);

        Label Angle = new Label();
        Angle.setText("Angle                                                                                        degree");
        Angle.setSize(400,20);
        Angle.setBounds(70,480,400,20);
        frame.add(scene_label);
        frame.add(score);
        frame.add(bird);
        frame.add(shooting_s);
        frame.add(Angle);

        // button
        JButton ok = new JButton();
        ok.setSize(80,20);
        ok.setText("OK");
        ok.setBounds(250,510,80,20);
        ok.addActionListener(this);
        frame.add(ok);

        // text field

        scores.setText("0");
        scores.setSize(90,40);
        scores.setEditable(false);
        scores.setBounds(460,45,90,40);
        frame.add(scores);

        frame.setSize(600,600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);

        panels.setSize(600,600);
        frame.add(panels);

        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        panels.angry_birds.fly(Double.parseDouble(y_axis.getText().replace("\s","")),Double.parseDouble(shooting_speed.getText().replace("\s","")),Double.parseDouble(Angle.getText().replace("\s","")));
        panels.angry_birds.update = true;


    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        game games = new game();
    }
}