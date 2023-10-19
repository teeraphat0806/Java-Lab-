import java.util.Random;

class objects{
    public Random rand = new Random();
    public double x;
    public double y;
    objects(double x,double y){
        this.x = x;
        this.y = y;
    }
    public void new_pos(int min_x,int max_x,int min_y,int max_y){
        this.x = rand.nextInt(min_x,max_x);
        this.y = rand.nextInt(min_y,max_y);
    }
}
