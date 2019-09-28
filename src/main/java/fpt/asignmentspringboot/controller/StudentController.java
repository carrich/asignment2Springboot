package fpt.asignmentspringboot.controller;

import fpt.asignmentspringboot.entity.LoginRequest;
import fpt.asignmentspringboot.entity.Student;
import fpt.asignmentspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("request", new LoginRequest());
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid LoginRequest loginRequest,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
     Student exixtStudent =   studentService.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        model.addAttribute("student", exixtStudent);
        return "detail";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String store(@Valid Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
//      Student savedStudent = studentService.luu(student);
//
//        model.addAttribute("student", savedStudent);
        return "login";
    }
}
