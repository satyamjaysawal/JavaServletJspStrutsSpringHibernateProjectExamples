package com.example;

import java.util.Comparator;

public interface SortingCriteria {
    Comparator<Employee> getComparatorByName();
    Comparator<Employee> getComparatorByEmail();
    Comparator<Employee> getComparatorByCountry();
    // Define more sorting criteria methods as needed
}
