public class Date {
    private int day;
    private String month;
    private int year;
    Date(){}
    Date(int day,String month,int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int get_day(){
        return this.day;
    }
    public String get_month(){
        return this.month;
    }
    public int get_year(){
        return this.year;
    }
    public void set_day(int day){
        this.day = day;
    }
    public void set_month(String month){
        this.month = month;
    }
    public void set_year(int year){
        this.year = year;
    }
}
