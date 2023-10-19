public class test {
    test(){
        ComparableCircle comparableCircle1 = new ComparableCircle();
        ComparableCircle comparableCircle2 = new ComparableCircle();
        comparableCircle1.circle = new Circle();
        comparableCircle1.circle.setRadius(20);
        comparableCircle2.circle = new Circle();
        System.out.println(find_biggest(new ComparableCircle[]{comparableCircle1,comparableCircle2}));
    }
    public static Circle find_biggest(ComparableCircle[] circles){
        Circle max = circles[0].circle;
        for(ComparableCircle c:circles){
            if(c.circle.getArea() > max.getArea()){
                max =c;
            }
        }
        return max;
    }
}
