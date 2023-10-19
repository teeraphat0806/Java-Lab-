import java.time.LocalDate;

public class Accounts {
    private int id;
    private double balance;
    private double annuallnterestRate;
    private Date dateCreated = new Date(9,"September",2023);
    private Person objPerson;
    private int age;
    Accounts(){}
    Accounts(int id,double balance){
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
    public Date get_dateCreated(){
        return dateCreated;
    }
    public int get_age(){
        return this.age;
    }
    public Person getObjPerson(){
        return this.objPerson;
    }
    public void set_id(int id){
        this.id = id;
    }
    public void set_balance(double balance){
        this.balance = balance;
    }
    public void set_age(int age){
        this.age = age;
    }
    public void set_annualInterestRate(double annuallnterestRate){

        this.annuallnterestRate = annuallnterestRate*0.01;
    }
    public void set_dateCreated(Date dateCreated){
        this.dateCreated = dateCreated;
    }
    public void setObjPerson(Person objPerson){
        this.objPerson = objPerson;
    }
    public void withdraw(double balance){
        if(this.balance >  balance || this.balance == balance){
            this.balance-=balance;
        }else{
            System.out.println("Your balance is less than withdraw amount");
        }
    }
    public void deposit(double balance){
        this.balance += balance;
    }
    public double getMonthlyInterestRate(){
        return (annuallnterestRate/12);
    }
    public double getMonthlyInterest(){
       return (annuallnterestRate/12)*balance;
    }
    public void transferMoney(Accounts acc1,double amount){
        acc1.deposit(amount);
        this.withdraw(amount);
    }


    public String toString() {
        return "Accounts{" +
                "id=" + id +
                '}';
    }
}
