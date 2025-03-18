package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling student-related web requests.
 */
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Display the list of all students
    @GetMapping
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";  // The 'students.html' template
    }

    // Show the form to add a new student
    @GetMapping("/new")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "new-student";  // The 'new-student.html' template
    }

    // Save a new student (with validation)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "new-student";  // Return to form if there are validation errors
        }
        studentService.addStudent(student);
        return "redirect:/students";  // Redirect to the student list view
    }

    // Delete a student using POST with _method=DELETE
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";  // Redirect to the student list view after deletion
    }

    // Fetch the list of students as JSON (for APIs or other purposes)
    @GetMapping("/json")
    @ResponseBody
    public List<Student> getStudentsAsJson() {
        return studentService.getAllStudents();
    }
}
