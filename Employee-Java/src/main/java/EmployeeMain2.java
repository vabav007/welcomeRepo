package main.java;

public class EmployeeMain2 {

        public static void main(String[] args){
        System.out.println("List of all Employees based on department" + EmployeeAction2.getEmployeeByDepartment());
        System.out.println("Total employees per department " + EmployeeAction2.getTotalEmployeesByDepartment());
        System.out.printf("Average salary per department"+ EmployeeAction2.getEmployeeAverageSalary());
        System.out.println("First 5 Employees are" + EmployeeAction2.getEmployeesFromList());
        System.out.println("Employees 2 to 5 are" + EmployeeAction2.getEmployeesFromListOnIndex(2,5));

}
}