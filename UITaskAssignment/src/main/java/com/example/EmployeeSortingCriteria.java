package com.example;

import java.util.Comparator;

public class EmployeeSortingCriteria implements SortingCriteria {
    @Override
    public Comparator<Employee> getComparatorByFirstName() {
        return new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getFirstname().compareTo(emp2.getFirstname());
            }
        };
    }

    @Override
    public Comparator<Employee> getComparatorByLastName() {
        return new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getLastname().compareTo(emp2.getLastname());
            }
        };
    }

    @Override
    public Comparator<Employee> getComparatorByEmail() {
        return new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getEmail().compareTo(emp2.getEmail());
            }
        };
    }

    @Override
    public Comparator<Employee> getComparatorByCountry() {
        return new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getCountry().compareTo(emp2.getCountry());
            }
        };
    }
}
