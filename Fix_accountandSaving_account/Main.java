import java.sql.Array;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;
class Account{
    private int id;
    private double balance;
    private double annuallnterestRate;
    private LocalDate dateCreated = LocalDate.now();
    Account(){}
    Account(int id,double balance){
        this.id = id;
        this.balance = balance;
    }
    public int get_id(){
        return this.id;
    }
    public double get_balance(){
        return this.balance;
    }
    public double get_annualInterestRate(){
        return this.annuallnterestRate;
    }
    public LocalDate get_dateCreated(){
        return dateCreated;
    }
    public void set_id(int id){
        this.id = id;
    }
    public void set_balance(double balance){
        this.balance = balance;
    }
    public void set_annualInterestRate(double annuallnterestRate){
        this.annuallnterestRate = annuallnterestRate*0.01;
    }
    public void set_dateCreated(LocalDate dateCreated){
        this.dateCreated = dateCreated;
    }

    public void withdraw(double balance){
        if(this.balance >  balance || this.balance == balance){
            this.balance-=balance;
        }
    }
    public void deposit(double balance){
        this.balance += balance;
    }
    public double getMonthlyInterestRate(){
        return (annuallnterestRate/12);
    }
    public double getMonthlyInterest(){
        return (annuallnterestRate*balance)/12;
    }

}
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void fix_account(){


        int id;
        double balance;
        double interestrate;
        Date d1 = new Date();
        String name;
        Person p1 = new Person();
        System.out.println("Creating new FixAccount");
        System.out.print("ID: ");
        id = input.nextInt();

        System.out.print("balance: ");
        balance = input.nextDouble();

        FixAccount ac1 = new FixAccount(id,balance); // create account
        FixAccount ac2 = new FixAccount(1100,5000);

        System.out.print("interest_rate: ");
        interestrate = input.nextDouble();
        ac1.set_annualInterestRate(interestrate);

        System.out.print("Name: ");
        name = input.next();
        p1.setName(name);
        System.out.print("Surname: ");
        name = input.next();
        p1.setSurname(name);
        ac1.setObjPerson(p1);

        System.out.print("Age: ");
        id = input.nextInt();
        ac1.set_age(id);
        System.out.println("Birth date:");
        System.out.print("Date: ");
        d1.set_day(input.nextInt());
        System.out.print("Month: ");
        d1.set_month(input.next());
        System.out.println("Year: ");
        d1.set_year(input.nextInt());
        ac1.set_dateCreated(d1);

        System.out.print("Withdraw: ");
        ac1.withdraw(input.nextDouble());

        System.out.print("deposit: ");
        ac1.deposit(input.nextDouble());

        System.out.print("ID to transfer money: ");
        id = input.nextInt();
        if(id == ac1.get_id()){
            System.out.println("can't transfer money to your own account");
        }else {
            System.out.print("Balance: ");
            balance = input.nextInt();
            ac1.transferMoney(ac2, balance);
        }
    }
    public static void saving_account(){
        List<Saving_Account> data_account= new ArrayList<Saving_Account>();

        int id;
        double balance;
        double interestrate;
        boolean access = false;
        Date d1 = new Date();
        String name;
        Person p1 = new Person();
        System.out.println("Creating new Saving_Account");
        System.out.print("ID: ");
        id = input.nextInt();

        System.out.print("balance: ");
        balance = input.nextDouble();

        Saving_Account ac1 = new Saving_Account(id,balance); // create account
        Saving_Account ac2 = new Saving_Account(1100,5000);

        data_account.add(ac2);

        System.out.print("interest_rate: ");
        interestrate = input.nextDouble();
        ac1.set_annualInterestRate(interestrate);

        System.out.print("Name: ");
        name = input.next();
        p1.setName(name);
        System.out.print("Surname: ");
        name = input.next();
        p1.setSurname(name);
        ac1.setObjPerson(p1);

        System.out.print("Age: ");
        id = input.nextInt();
        ac1.set_age(id);
        System.out.println("Birth date:");
        System.out.print("Date: ");
        d1.set_day(input.nextInt());
        System.out.println("Month: ");
        d1.set_month(input.next());
        System.out.println("Year: ");
        d1.set_year(input.nextInt());
        ac1.set_dateCreated(d1);

        System.out.print("Withdraw: ");
        ac1.withdraw(input.nextDouble());

        System.out.print("deposit: ");
        ac1.deposit(input.nextDouble());

        System.out.print("ID to transfer money: ");
        id = input.nextInt();
        for(Saving_Account aa: data_account){
            if(aa.get_id() == id){
                System.out.print("amount: ");
                balance = input.nextDouble();
                ac1.transferMoney(aa,balance);
                access = true;
                System.out.println("balance: " + ac1.get_balance() + " AnnualInterestMontly: " + ac1.getMonthlyInterest());
            }
        }
        if(id == ac1.get_id()){
            System.out.println("can't transfer money to your own account");
        }
        else if(access == false){
            System.out.println("can't find id to transfer money");
        }
    }
    public static void main(String[] args) {
        Account ac1 = new Account(1122,20000);
        ac1.set_annualInterestRate(4.5);
        ac1.withdraw(2500);
        ac1.deposit(3000);
        System.out.println("balance: " + ac1.get_balance() + " MonthlyInterestRate: " + ac1.getMonthlyInterestRate());
    }
}