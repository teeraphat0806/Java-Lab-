import javax.swing.*;
import java.awt.*;
import java.math.*;

abstract class AbstractDrawFunction extends JPanel
{
    /**Polygon to hold the points*/
    private Polygon p = new Polygon();
    /**Default constructor*/
    protected AbstractDrawFunction ()
    {
        drawFunction();
        setBackground(Color.white);
    }
    /**Draw the function*/
    public abstract double f(double x);
    /**Obtain points for x coordinates 100, 101, ..., 300*/
    public void drawFunction()
    {
        for (int x = -100; x <= 100; x++)
        {
            p.addPoint(x+200, 200-(int)f(x));
        }
    }
    /**Paint the function diagram*/
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
// Draw x axis
        g.drawLine(10, 200, 390, 200);
// Draw y axis
        g.drawLine(200,30, 200, 390);

        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);

        g.drawLine(200, 30, 190, 50);
        g.drawLine(200, 30, 210, 50);
// Draw x, y
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);
// Draw a polygon line by connecting the points in the polygon
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}
class a extends AbstractDrawFunction {
    protected a(){
        drawFunction();
        setBackground(Color.white);
    }
    @Override
    public double f(double x) {
        return Math.pow(x,2);
    }
}
class b extends AbstractDrawFunction {
    protected b(){
        drawFunction();
        setBackground(Color.white);
    }
    @Override
    public double f(double x) {
        return Math.sin(x)*100;
    }
}
class c extends AbstractDrawFunction {
    protected c(){
        drawFunction();
        setBackground(Color.white);
    }
    @Override
    public double f(double x) {
        return Math.cos(x)*100;
    }
}
class d extends AbstractDrawFunction {
    protected d(){
        drawFunction();
        setBackground(Color.white);
    }
    @Override
    public double f(double x) {
        return Math.tan(x);
    }
}
class e extends AbstractDrawFunction {
    protected e(){
        drawFunction();
        setBackground(Color.white);
    }
    @Override
    public double f(double x) {
        return Math.cos(x)+(5*Math.sin(x));
    }
}
class f extends AbstractDrawFunction {
    protected f(){
        drawFunction();
        setBackground(Color.white);
    }
    @Override
    public double f(double x) {
        return (5*Math.cos(x))+Math.sin(x);
    }
}
class g extends AbstractDrawFunction {
    protected g(){
        drawFunction();
        setBackground(Color.white);
    }
    @Override
    public double f(double x) {
        return Math.log(x)+Math.pow(x,2);
    }
}
 class Test extends JFrame
{
    public Test()
    {
        getContentPane().setLayout(new GridLayout(1, 2, 5, 5));
        getContentPane().add(new a());
        getContentPane().add(new b());
        getContentPane().add(new c());
        getContentPane().add(new d());
        getContentPane().add(new e());
        getContentPane().add(new f());

    }
    public static void main(String[] args)
    {
        Test frame = new Test();
        frame.setSize(400, 400);
        frame.setTitle("Exercise 10.10");
        frame.setVisible(true);
    }
}