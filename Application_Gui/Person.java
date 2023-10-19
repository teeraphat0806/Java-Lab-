public class Person {
    private String name;
    private String surname;
    private int age;
    private Date bDate;
    Person(){}
    Person(String name,String surname){
        this.name = name;
        this.surname = surname;
    }
    public String get_name(){
        return this.name;
    }
    public String get_surname(){
        return this.surname;
    }
    public int getAge(){
        return  this.age;
    }
    public Date getbDate(){
        return this.bDate;
    }
    public void setName(String Name){
        this.name = Name;
    }
    public void setSurname(String Surname){
        this.surname = Surname;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setbDate(Date bDate){
        this.bDate = bDate;
    }

}
