package main.java;

public class Employee {

    private String department;
    private String firstName;
    private String lastName;
    private double salary;

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee(String firstName, String lastName, double salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public void setSalary(double salary) {
                this.salary = salary;
        }

        public void setDepartment(String department) {
                this.department = department;
        }

        public String getFirstName() {
                return firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public double getSalary() {
                return salary;
        }

        public String getDepartment() {
                return department;
        }

    public static boolean isDepartment(Employee department) {
        Employee e = new Employee();
        if(department.equals(e.getDepartment()))
            return true;
        else
            return false;
    }
}
