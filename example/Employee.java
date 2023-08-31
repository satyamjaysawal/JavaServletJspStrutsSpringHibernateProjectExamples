package example;

import java.util.Objects;

class Employee {
    private int empNo;
    private String empName;
    private double salary;

    public Employee(int empNo, String empName, double salary) {
        this.empNo = empNo;
        this.empName = empName;
        this.salary = salary;
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmpNo: " + empNo + " | EmpName: " + empName + " | Salary: " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empNo == employee.empNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo);
    }
}
