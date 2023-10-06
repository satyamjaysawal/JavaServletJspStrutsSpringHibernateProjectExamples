package com.example;

import java.util.Comparator;

public interface SortingCriteria {
    Comparator<Employee> getComparatorByFirstName();
    Comparator<Employee> getComparatorByLastName();
    Comparator<Employee> getComparatorByEmail();
    Comparator<Employee> getComparatorByCountry();
}
