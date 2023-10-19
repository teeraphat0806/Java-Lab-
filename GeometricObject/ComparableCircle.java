import java.lang.Comparable.*;
public class ComparableCircle extends Circle implements Comparable<Circle>{
    protected Circle circle;
    public void setCircle(Circle circle){
        this.circle = circle;
    }
    public Circle getCircle(){
        return circle;
    }
    @Override
    public int compareTo(Circle c1){
        if(this.circle.getArea() == c1.getArea()){
            return 1;
        }else{
            return 0;
        }
    }
}
