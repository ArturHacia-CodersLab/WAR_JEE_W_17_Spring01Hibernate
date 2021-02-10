package pl.coderslab.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.student.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("C++", "Java", "PHP", "Python", "JavaScript");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("sport", "gry komputerowe", "muzyka", "używki", "filmy i seriale");
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String saveStudent(@ModelAttribute Student student) {
        return student.toString();
    }
}
