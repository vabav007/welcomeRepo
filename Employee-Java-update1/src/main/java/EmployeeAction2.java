package main.java;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class EmployeeAction2 {

    public static List<Employee> getEmployees2() {
        return Arrays.asList(new Employee("Bryan", "Adams", 52500.0, "Sales"),
                new Employee("Jack", "Ryan", 100500.0, "IT"),
                new Employee("Juan", "Carlos", 77000.0, "HR"),
                new Employee("Emily", "Blunt", 84500.0, "Finance"),
                new Employee("Josh", "King", 32700.0, "Sales"),
                new Employee("Joel", "Matip", 121500.0, "IT"),
                new Employee("Donald", "Reagen", 112000.0, "Finance"),
                new Employee("James", "Shaw", 18070.0, "HR"),
                new Employee("Jake", "Luke", 25000.0, "IT"),
                new Employee("Emma", "Smith", 13000.5, "HR"),
                new Employee("Ryan", "Seacrest", 12700.0, "Finance"),
                new Employee("Hailey", "Williams", 52000.0, "IT"));
    }

    public static Map<String, List<Employee>> getEmployeeByDepartment(){
        Map<String, List<Employee>> EmployeesByDepartment =
                getEmployees2().stream()
                        .collect(groupingBy(
                                Employee::getDepartment
                        ));
        return EmployeesByDepartment;

    }

    public static int getTotalEmployeesByDepartment(){
       return getEmployees2().stream()
                .map(Employee::getDepartment)
                .distinct().(Integer::sum).ifPresent(System.out::println); // type error collect . grouping by
    }


    public static Map<String, Employee> getEmployeeAverageSalary() {
        Map<String, Employee> average =
                getEmployees2().stream() // collectors use average method, group by dept
                        .collect(groupingBy(
                                e -> e.getDepartment(),
                                collectingAndThen(averagingDouble(Employee::getSalary), Collections::unmodifiableList) ) // SQL built in method type error
                        );
        return average;
    }

    public static List<Employee> getEmployeesFromList() {
        List<Employee> s = (List<Employee>) getEmployees2().stream()
                .limit(5);
        return s;
    }

    public static List<Employee> getEmployeesFromListOnIndex(int start, int end) {
        List<Employee> e = getEmployees2().stream()
                .filter(e.indexOf(start)) // limit 5 , skip method
                .filter(e.lastIndexOf(end))
                .collect(Collectors.toList());

      return e;
    }
}
