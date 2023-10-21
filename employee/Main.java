
public class Main {
    public static void main(String[] args) {
        Employee emp = new Manager();
        emp.setSalary(10000);
        emp.setAddress(new Address());
        emp.getAddress().setCity("Florida");
        emp.getAddress().setStreet("Away new");
        emp.setId(1);
        emp.setName("John");
        System.out.println(emp.getDetails());
    }
}