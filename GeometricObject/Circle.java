import java.lang.Comparable.*;
import java.math.*;
public class Circle extends GeometricObject implements Comparable<Circle>{
    private double radius;
    @Override
    public double getArea() {
        return Math.PI* Math.pow(radius,2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI*2*radius;
    }

    @Override
    public int compareTo(Circle o) {
        if(this.radius == o.radius){
            return 1;
        }else{
            return 0;
        }
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
}