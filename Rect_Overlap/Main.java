class MyRectangle2D{
    private double x,y;
    private double height,width;
    MyRectangle2D(){
        this.x = 0;
        this.y = 0;
        this.height = 1;
        this.width = 1;
    }
    MyRectangle2D(double x,double y,double height,double width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public double getArea(){
        return  this.width*this.height;
    }
    public double getPerimeter(){
        return (this.width*2)+(this.height*2);
    }
    public boolean contains(double x1,double y1){
        if(((this.x - (this.width /2) >= x1) || (this.x + (this.width /2) <= x1)) && ((this.y - (this.height /2) >= y1) || (this.x + (this.height /2) <= y1)) ){
            return true;
        }else{
            return  false;
        }
    }
    public boolean contains(MyRectangle2D r1){
        double x1 = r1.getX();
        double y1 = r1.getY();
        double[][] pos_1 =
                {{x1-(r1.getWidth()/2),y1-(r1.getHeight()/2)},
                {x1+(r1.getWidth()/2),y1-(r1.getHeight()/2)},
                {x1-(r1.getWidth()/2),y1+(r1.getHeight()/2)},
                {x1+(r1.getWidth()/2),y1+(r1.getHeight()/2)}};
        double[][] my_pos =
                {{this.x-(this.width/2),this.y-(this.height/2)},
                        {this.x+(this.width/2),this.y-(this.height/2)},
                        {this.x-(this.width/2),this.y+(this.height/2)},
                        {this.x+(this.width/2),this.y+(this.height/2)}};
        return (pos_1[0][0] >= my_pos[0][0] && pos_1[0][1] <= my_pos[0][1]) && ((pos_1[1][0] <= my_pos[1][0] && pos_1[0][1] <= my_pos[0][1]))
                && ((pos_1[2][0] >= my_pos[2][0] && pos_1[2][1] >= my_pos[2][1])) && ((pos_1[3][0] <= my_pos[3][0] && pos_1[2][1] >= my_pos[3][1]));
    }
    public boolean overlaps(MyRectangle2D r1){
        double x1 = r1.getX();
        double y1 = r1.getY();
        double[][] pos_1 =
                {{x1-(r1.getWidth()/2),y1-(r1.getHeight()/2)},
                        {x1+(r1.getWidth()/2),y1-(r1.getHeight()/2)},
                        {x1-(r1.getWidth()/2),y1+(r1.getHeight()/2)},
                        {x1+(r1.getWidth()/2),y1+(r1.getHeight()/2)}};
        double[][] my_pos =
                {{this.x-(this.width/2),this.y-(this.height/2)},
                        {this.x+(this.width/2),this.y-(this.height/2)},
                        {this.x-(this.width/2),this.y+(this.height/2)},
                        {this.x+(this.width/2),this.y+(this.height/2)}};
        return  (pos_1[0][0] > my_pos[0][0] && pos_1[0][1] < my_pos[0][1] && pos_1[0][0] < my_pos[1][0]) || ((pos_1[1][0] < my_pos[1][0] && pos_1[1][1] < my_pos[1][1] && pos_1[1][0] > my_pos[0][0]))
                || ((pos_1[2][0] > my_pos[2][0] && pos_1[2][1] > my_pos[2][1] && pos_1[2][0] < my_pos[3][0])) || ((pos_1[3][0] < my_pos[3][0] && pos_1[2][1] > my_pos[3][1] && pos_1[3][0]<my_pos[2][0]));
    }
    public double getX(){
        return  this.x;
    }
    public double getY(){
        return  this.y;
    }
    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return  this.width;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

}
public class Main {
    public static void main(String[] args) {
    }
}