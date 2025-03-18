package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for managing student records.
 */
@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>(); // In-memory list of students

    /**
     * Retrieve all students.
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Add a new student.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Delete a student by ID.
     */
    public void deleteStudentById(Integer id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
