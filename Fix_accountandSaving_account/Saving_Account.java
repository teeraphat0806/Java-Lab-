
public class Saving_Account extends Accounts{

    Saving_Account(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void transferMoney(Accounts acc1,double amount){
        acc1.deposit(amount);
        this.withdraw(20+amount);
    }
}
