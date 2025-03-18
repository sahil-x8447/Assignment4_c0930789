package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        studentService = new StudentService();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("Sahil Sharma", "sahil.sharma@example.com", 20);
        int initialSize = studentService.getAllStudents().size();

        studentService.addStudent(student);

        assertEquals(initialSize + 1, studentService.getAllStudents().size());
    }

    @Test
    public void testDeleteStudentById() {
        Student student = new Student("Sahil Sharma", "sahil.sharma@example.com", 20);
        studentService.addStudent(student);
        int initialSize = studentService.getAllStudents().size();

        studentService.deleteStudentById(student.getId());

        assertEquals(initialSize - 1, studentService.getAllStudents().size());
    }
}
