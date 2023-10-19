import java.lang.Comparable.*;
import java.math.*;
public class Rectangle extends GeometricObject implements Comparable<Rectangle>{
    public double width;
    public double height;
    @Override
    public int compareTo(Rectangle r){
        if(this.getArea() == r.getArea()){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return (width*2)+(height*2);
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setHeight(double height){
        this.height = height;
    }

}
