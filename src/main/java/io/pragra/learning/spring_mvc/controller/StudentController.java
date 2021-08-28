package io.pragra.learning.spring_mvc.controller;

import io.pragra.learning.spring_mvc.entity.Student;
import io.pragra.learning.spring_mvc.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller // returning view
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/student")
    public String getAllStudent(Model model){
        model.addAttribute("student", service.getAll());
        return "student";
    }

    @PostMapping("/student")
    public String createStudent(@ModelAttribute("student") Student student, Model model){
        service.createStudent(student);
        model.addAttribute("student", service.getAll());// mapping the object "students" to the method.
        return "student";
    }
    /*
    The @ModelAttribute is an annotation that binds
     a method parameter or method return value to
     a named model attribute and then exposes it to a web view.
     */


    @GetMapping("/addstudent")
    public String getAllStudentS(Model model){
        model.addAttribute("student", new Student());
        return "addstudent";
    }
}


