import java.awt.*;
import java.lang.Comparable.*;
import java.math.*;
 class ComparableCircle extends Circle implements Comparable<Circle>{
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
 abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    protected GeometricObject() {
    }
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

 class Octagon extends GeometricObject implements Comparable<Octagon>,Cloneable{
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

 class Rectangle extends GeometricObject implements Comparable<Rectangle>{
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
 class Circle extends GeometricObject implements Comparable<Circle>{
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

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Octagon oc = new Octagon();
        oc.setColor("Green");
        oc.setSide(5);
        System.out.println("Area: " + oc.getArea() + " Perimeter: "+oc.getPerimeter());
        Octagon oc1 = (Octagon) oc.clone();
        System.out.println( oc.compareTo(oc1));

        test t1 = new test();
    }

}
