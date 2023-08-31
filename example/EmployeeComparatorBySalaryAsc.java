package example;

import java.util.Comparator;

public class EmployeeComparatorBySalaryAsc implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        // Compare employees by salary in ascending order
        if (emp1.getSalary() < emp2.getSalary()) {
            return -1;
        } else if (emp1.getSalary() > emp2.getSalary()) {
            return 1;
        }
        return 0;
    }
}
