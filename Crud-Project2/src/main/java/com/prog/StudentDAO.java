package com.prog;

import java.util.List;

public interface StudentDAO {
    void saveStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudent(int studentId);
    void updateStudent(int studentId, String newName);
}
