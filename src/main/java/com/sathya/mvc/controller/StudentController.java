package com.sathya.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.mvc.entity.StudentEntity;
import com.sathya.mvc.model.StudentModel;
import com.sathya.mvc.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Display form for adding new student
    @GetMapping("/addStudent")
    public String getStudentForm(Model model) {
        StudentModel studentModel = new StudentModel();
        studentModel.setStudClg("bvrith"); // Setting default college value
        model.addAttribute("studentModel", studentModel);
        model.addAttribute("page", "addStudent");
        return "index";  // Assuming index.html is your main page to render forms
    }

    // Save new student
    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute StudentModel studentModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("page", "addStudent");  // Redisplay form on validation errors
            return "index";
        }
        studentService.saveStudentData(studentModel);
        model.addAttribute("page", "saveStudent");
        return "index";
    }

    // Get and display all students
    @GetMapping("/getStudents")
    public String getStudents(Model model) {
        List<StudentEntity> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("page", "getStudents");
        return "index";
    }

    // Delete student by ID
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/getStudents";
    }

    // Display search form
    @GetMapping("/searchform")
    public String getSearchForm(Model model) {
        model.addAttribute("studentModel", new StudentModel());
        model.addAttribute("page", "searchform");
        return "index";
    }

    // Search student by ID
    @GetMapping("/searchStudent")
    public String searchStudent(@RequestParam Long studId, Model model) {
        StudentEntity student = studentService.getStudentById(studId);
        if (student != null) {
            model.addAttribute("student", student);
        } else {
            model.addAttribute("error", "Student not found!");
        }
        model.addAttribute("page", "searchform");
        return "index";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam long studId, Model model) {
        StudentModel studentModel = studentService.searchStudentById(studId);
        model.addAttribute("studentModel", studentModel);
        model.addAttribute("categories", Arrays.asList("cse", "ece", "civil", "mech")); // Predefined categories
        model.addAttribute("studId", studId);
        return "editform";  // Assuming this is the template for the edit form
    }

    // Handle update request
    @PostMapping("/update")
    public String updateStudent(@RequestParam Long studId, @ModelAttribute StudentModel studentModel) {
        studentService.updateStudentData(studId, studentModel); // Update the student data
        return "redirect:/getStudents"; // Redirect to the list after update
    }


    // Contact page route
    @GetMapping("/contact")
    public String submitContactForm(Model model) {
        model.addAttribute("page", "contact");
        return "index";
    }

    // About page route
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("page", "about");
        return "index";
    }

    // Home page route
    @GetMapping("/")
    public String homePage() {
        return "index";
    }
}
