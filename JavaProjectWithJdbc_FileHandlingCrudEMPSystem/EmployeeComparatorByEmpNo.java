package JavaProjectWithJdbc_FileHandlingCrudEMPSystem;

import java.util.Comparator;

public class EmployeeComparatorByEmpNo implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Integer.compare(emp1.getEmpNo(), emp2.getEmpNo());
    }
}
