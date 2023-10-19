import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class angry_bird extends objects{
    public Image bird;
    public double des_x,des_y;
    public double r_x,r_y;
    public double des_time = 0;
    public double time=0;
    public double degree;
    public double u;
    public boolean update=false;

    angry_bird(int x,int y) throws IOException {
        super(x,y);
        BufferedImage birds = ImageIO.read(new File("res/angry_bird.png"));
        bird = birds.getScaledInstance(50,50,Image.SCALE_DEFAULT);
    }
    public void fly(double sy,double u,double degree){
        des_time = ((u*(-1)*Math.sin(Math.toRadians(degree)))-(Math.sqrt(Math.pow(u*Math.sin(Math.toRadians(degree)),2)-(4*(-5)*sy*(-1)))))/(-10);
        des_time = Math.abs(des_time);
        des_x = u*Math.cos(Math.toRadians(degree))*des_time;
        des_y = y-1;
        this.u =u;
        this.degree = degree;
        r_x = x;
        r_y = y;
    }
    public double find_x(){
        return u*Math.cos(Math.toRadians(degree))*time;
    }
    public double find_y(){
        return u*Math.sin(Math.toRadians(degree))*time+(-9.8)*(0.5)*Math.pow(time,2);
    }
}