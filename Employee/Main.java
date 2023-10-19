import java.util.ArrayList;
import java.util.Scanner;
class Salaried_Employee extends Employee{
    public double salary;
    public Salaried_Employee(String firstname, String lastname, String id,double sal) {
        super(firstname, lastname, id);
        salary = sal;
    }

    @Override
    public double earning() {
        return salary-(salary*0.5);
    }

    @Override
    public double bonus(int year) {
        if(year >5) return salary*12;
        else return salary*6;
    }

}
class ComEmpolyee extends  Employee{
    public double grossSale;
    public double ComRate;
    public ComEmpolyee(String firstname, String lastname, String id, double sales,double percent) {
        super(firstname, lastname, id);
        grossSale = sales;
        ComRate = percent;
    }

    @Override
    public double earning() {
        return grossSale*ComRate;
    }

    @Override
    public double bonus(int year) {
        if(year > 5) return grossSale*6;
        else return  grossSale*3;
    }
}
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Employee> employee = new ArrayList<Employee>();
        Salaried_Employee s1 = new Salaried_Employee("jack","reacher","1",300000);
        Salaried_Employee s2 = new Salaried_Employee("jason","statom","2",600000);
        ComEmpolyee c1 = new ComEmpolyee("vin","statejohnson","3",5000000,20);
        ComEmpolyee c2 = new ComEmpolyee("hanny","lawson","4",8090000,20);
        employee.add(s1);
        employee.add(s2);
        employee.add(c1);
        employee.add(c2);
        printEmp(employee);
    }
    public static void printEmp(ArrayList<Employee> a){
        int year;
        System.out.print("year:");
        year = input.nextInt();
        System.out.println("First name\t\tLast name\t\tEarning\t\tBonus\t\t" );
        ArrayList<Double> arrayEarn = new ArrayList<Double>();
        ArrayList<Double> arrayBonus = new ArrayList<Double>();


        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i).firstname + "\t\t" + a.get(i).lastname + "\t\t" + a.get(i).earning() + "\t\t" +a.get(i).bonus(year));
            arrayEarn.add(a.get(i).earning());
            arrayBonus.add(a.get(i).bonus(year));
        }
    }
}