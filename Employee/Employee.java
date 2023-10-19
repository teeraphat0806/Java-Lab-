public abstract class Employee {
    public String firstname;
    public String lastname;
    public String id;

    public Employee(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public abstract double earning();

    public abstract double bonus(int year);
}
