import java.util.Scanner;
import java.lang.Math;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Roach_Population{
    private int n;
    public Roach_Population(int n){
        this.n = n;
    }
    public void waited(){
       this.n*=2;
    }
    public void spray(){
        this.n = (int) Math.ceil(this.n - (this.n*0.1));
    }
    public int get_Roaches(){
        return this.n;
    }
}
public class Main {
    public static int n,lap;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        lap = input.nextInt();
        Roach_Population r1 = new Roach_Population(n);
        for(int i=0; i <lap;i++){
            r1.waited();
            r1.spray();
        }


        System.out.println(r1.get_Roaches());
        }

    }
