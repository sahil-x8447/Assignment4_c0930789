package com.example.studentmanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a Student entity with basic validation.
 */
public class Student {
    private static int idCounter = 1; // Auto-incremented ID

    private Integer id;

    @NotNull
    @Size(min = 2, max = 40, message = "Name must be between 2 and 40 characters")
    private String name;

    @NotNull
    @Email(message = "Invalid email format")
    private String email;

    @NotNull
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    public Student() {
        this.id = idCounter++;
    }

    public Student(String name, String email, Integer age) {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Integer getAge() { return age; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAge(Integer age) { this.age = age; }
}
