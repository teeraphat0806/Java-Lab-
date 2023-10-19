import java.time.LocalDate;

public class FixAccount extends Accounts{

    FixAccount(int id, double balance) {
        super(id, balance);
    }
    @Override
    public void transferMoney(Accounts acc1,double amount){
        System.out.println("can't transfer money to "+acc1.get_id());
    }
    public void withdraw(double balance){
        int year = this.get_dateCreated().get_year();
        int year_now= LocalDate.now().getYear();
        if(year_now-year > 0){
            if(this.get_balance() >  balance || this.get_balance() == balance){
                this.set_balance(this.get_balance()-balance);
            }else{
                System.out.println("can't withdraw money");
            }
        }else{
            System.out.println("can't withdraw money");
        }
    }
}
