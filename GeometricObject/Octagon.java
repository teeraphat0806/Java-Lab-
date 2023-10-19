import java.lang.Comparable.*;
import java.lang.Cloneable.*;
import java.lang.Math.*;
public class Octagon extends GeometricObject implements Comparable<Octagon>,Cloneable{
    private double side;
    @Override
    public double getArea() {
        return (2+4/Math.sqrt(2))*side*side;
    }

    @Override
    public double getPerimeter() {
        return 8*side;
    }

    @Override
    public int compareTo(Octagon oc){
        if(this.getArea() == oc.getArea()){
            return 1;
        }else{
            return 0;
        }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public void setSide(double side){
        this.side = side;
    }
    public double getSide(){
        return side;
    }
}
