package com.prog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateStudentDAO implements StudentDAO {

    private final SessionFactory sessionFactory;

    public HibernateStudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
                tx.commit();
                System.out.println("Student with ID " + studentId + " deleted successfully.");
            } else {
                System.out.println("No student found with ID " + studentId + ". Deletion failed.");
            }
        }
    }

    @Override
    public void updateStudent(int studentId, String newName) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                student.setName(newName);
                session.update(student);
                tx.commit();
                System.out.println("Student with ID " + studentId + " updated successfully.");
            } else {
                System.out.println("No student found with ID " + studentId + ". Update failed.");
            }
        }
    }
}
