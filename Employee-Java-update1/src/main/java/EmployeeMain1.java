package main.java;


public class EmployeeMain1 {

   // private static boolean Map;

    public static void main(String[] args) {

       // List<Employee> employees = EmployeeAction1.getEmployees();


        System.out.println("List of Employees in searched department" + EmployeeAction1.getEmployeeOnDepartment("Finance"));
        System.out.println("Total salary " + EmployeeAction1.getTotalSalary());
        System.out.printf("Employee with highest salary is %s%n", EmployeeAction1.getEmployeeWithHighestSalary());
        System.out.println("List of Employees with decreasing salary by department" + EmployeeAction1.getEmployeesSortedOnDepartmentAndSalary());
    }

}
