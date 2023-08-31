package com.FullJavaJdbcFileCollectionCustom;

import java.util.Comparator;

public class StudentComparator {

    public static Comparator<Student> comparingIntId() {
        return Comparator.comparingInt(Student::getId);
    }

    public static Comparator<Student> comparingStringName() {
        return Comparator.comparing(Student::getName);
    }
}
