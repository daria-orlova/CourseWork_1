import java.text.NumberFormat;

public class Employee {
    private static final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    private String fullName;
    private int department;
    private int salary;
    private int id;
    private static int counter = 1;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return fullName + ", департамент: " + department + ", зарплата: " + numberFormat.format(salary);
    }
}
