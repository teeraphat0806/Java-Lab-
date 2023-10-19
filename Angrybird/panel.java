import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class panel extends JPanel implements ActionListener{
    public angry_bird angry_birds = new angry_bird(37,100); // y= 100-420 X=37-500
    public pig pigs = new pig(37,100);
    public double score = 0;
    public boolean collapse=false;
    public game games;
    panel(int width,int height,game games) throws IOException {
        this.setPreferredSize(new Dimension(width,height));
        this.games = games;
        while(angry_birds.x == pigs.x && angry_birds.y == pigs.y){
            angry_birds.new_pos(37,500,100,350);
            pigs.new_pos(37,500,100,350);
        }
        Animation();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        try {
            BufferedImage scene1 = ImageIO.read(new File("res/galaxy.jpg"));
            Image galaxy = scene1.getScaledInstance(510,300,Image.SCALE_DEFAULT);
            g2.drawImage(galaxy,37,100,null);
            g2.drawImage(angry_birds.bird,(int)angry_birds.x, (int) angry_birds.y, null);
            g2.drawImage(pigs.pig, (int) pigs.x,(int)pigs.y,null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void Animation(){
        Timer timer = new Timer(10,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(angry_birds.update && (angry_birds.time <angry_birds.des_time)){
            angry_birds.x = angry_birds.r_x+angry_birds.find_x();
            angry_birds.y = angry_birds.r_y-angry_birds.find_y();
            angry_birds.time +=0.1;
            this.repaint();
        }
        if(angry_birds.x > pigs.x-pigs.pig.getWidth(null)-20&&angry_birds.x < pigs.x+pigs.pig.getWidth(null)+20 &&angry_birds.y > pigs.y-pigs.pig.getHeight(null)-20&&angry_birds.y < pigs.y+pigs.pig.getHeight(null)+20 && angry_birds.update ){
            collapse = true;
        }else{
            score = -100;
        }
        if(collapse){
            score = 100;
        }
        if(angry_birds.update){
            games.scores.setText(Double.toString(score));
        }


    }
}
