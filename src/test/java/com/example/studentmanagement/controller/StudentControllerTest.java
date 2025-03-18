package com.example.studentmanagement.controller;

import com.example.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(StudentController.class) // Focus on testing the StudentController
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc; // Used to simulate HTTP requests and verify responses

    @MockBean
    private StudentService studentService; // Mock the StudentService

    @Test
    public void testGetAllStudents() throws Exception {
        // Simulate a GET request to '/students' and verify the response
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk()) // Expect 200 OK status
                .andExpect(view().name("students")); // Expect the view name to be 'students'
    }

    @Test
    public void testShowAddStudentForm() throws Exception {
        // Simulate a GET request to '/students/new' and verify the response
        mockMvc.perform(get("/students/new"))
                .andExpect(status().isOk()) // Expect 200 OK status
                .andExpect(view().name("new-student")); // Expect the 'new-student' view to be returned
    }

    @Test
    public void testSaveStudent() throws Exception {
        // Simulate the POST request to save a student using your name and email
        mockMvc.perform(post("/students/save")
                        .param("name", "Sahil Sharma")
                        .param("email", "sahil.sharma@example.com")
                        .param("age", "21"))
                .andExpect(status().is3xxRedirection()) // Expect a redirect status (3xx)
                .andExpect(view().name("redirect:/students")); // Expect a redirect to '/students'
    }

    @Test
    public void testDeleteStudent() throws Exception {
        // Simulate the POST request to delete a student by ID (assume ID 1)
        mockMvc.perform(post("/students/delete/{id}", 1))
                .andExpect(status().is3xxRedirection()) // Expect a redirect status (3xx)
                .andExpect(view().name("redirect:/students")); // Expect a redirect to '/students'
    }
}
