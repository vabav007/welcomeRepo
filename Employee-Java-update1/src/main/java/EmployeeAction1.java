package main.java;

import java.util.*;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class EmployeeAction1 {

    public static List<Employee> getEmployees1() {
        return Arrays.asList(new Employee("Bryan", "Adams", 52500.0, "Sales"),
                new Employee("Rick", "Turner", 100500.0, "IT"),
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

    
    public static List<Employee> getEmployeeOnDepartment(String department) {

        return getEmployees1().stream()
                      //  .filter(Employee::isDepartment)
                        .filter(x -> x.getDepartment()
                                .contains(department)).collect(Collectors.toList()); // not able to apply reduce
    }

  /*  private static void collect(Collector<Object,?, List<Object>> toList) {
    } */

    public static double getTotalSalary(){
        List<Employee> employees = EmployeeAction1.getEmployees1();
        DoubleSummaryStatistics totalSalary= employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        return totalSalary.getSum();
    }

    public static Map<String, Employee> getEmployeeWithHighestSalary() {
        Map<String, Employee> topEmployees =
                getEmployees1().stream()
                        .collect(groupingBy(
                                Employee::getDepartment,
                                collectingAndThen(maxBy(comparingDouble(Employee::getSalary)), Optional::get)
                        ));
        return topEmployees;
    }

    public static List<Employee> getEmployeesSortedOnDepartmentAndSalary() {
        List<Employee> employees = EmployeeAction1.getEmployees1();
        return employees.stream().sorted(Comparator.comparing(Employee::getDepartment)
                .thenComparingDouble((ToDoubleFunction<? super Employee>) Comparator
                        .comparingDouble(Employee::getSalary).reversed())).
                collect(Collectors.toList());

    }


}