public class Employee{
    protected int id;
    protected String name;
    protected double salary;
    protected Address address;
    public String getDetails(){
        return "Id: "+id+"\tName: "+name+"\tSalary:"+salary+"\t"+address.getAddressInfo();
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public Address getAddress(){
        return address;
    }
    public void setAddress(Address address){
        this.address = address;
    }
}