import java.lang.Math;
import java.util.Scanner;
public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        double x1,x2,x3,y1,y2,y3;
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        x3 = input.nextDouble();
        y3 = input.nextDouble();
        if(leftOfTheLine(x1,y1,x2,y2,x3,y3)) {
            System.out.println(2);
        }else if(rightOfTheLine(x1,y1,x2,y2,x3,y3)){
            System.out.println(1);
        }else if(onTheLineSegment(x1,y1,x2,y2,x3,y3)){
            System.out.println(0);
        }

    }
    public static boolean leftOfTheLine(double x0,double y0,double x1,double y1,double x2,double y2){
        return x2 < x1 && x2 < x0;
    }
    public static boolean rightOfTheLine(double x0,double y0,double x1,double y1,double x2,double y2){
        return x2 > x1 && x2 > x0;
    }
    public static boolean onTheSameLine(double x0,double y0,double x1,double y1,double x2,double y2){
        return (x2 > x1 && x2 < x0) || (x2 < x1 && x2 > x0) && (x2 == y2);
    }
    public static boolean onTheLineSegment(double x0,double y0,double x1,double y1,double x2,double y2){
        x1 = x1 - x0;
        y1 = y1 - y0;
        x2 = x2 - x0;
        y2 = y2 - y0;
        return (x1 * y2 - x2 * y1) == 0;
    }
}