package JavaProjectWithJdbc_FileHandlingCrudEMPSystem;

import java.util.Comparator;

public class EmployeeComparatorBySalaryDesc implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Double.compare(emp2.getSalary(), emp1.getSalary());
    }
}
