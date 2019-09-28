package fpt.asignmentspringboot.controller;

import fpt.asignmentspringboot.entity.AptechClass;
import fpt.asignmentspringboot.entity.Student;
import fpt.asignmentspringboot.repository.AptecClassRepository;
import fpt.asignmentspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/class")
public class ClassController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AptecClassRepository aptecClassRepository;
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(Model model) {
      List<AptechClass> classList = aptecClassRepository.findAll();
        model.addAttribute("classes", classList);
        return "classList";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDetail(@PathVariable int id, Model model, HttpServletRequest request) {

        Optional<AptechClass> aptechClass = aptecClassRepository.findById(id);
        AptechClass aptechClass1 = new AptechClass();
        if (aptechClass != null) {
            request.getSession().setAttribute("classId",id);
            aptechClass1 = aptechClass.get();
        }
        List<Student> students = studentRepository.findAll();
        model.addAttribute("class", aptechClass1);
        model.addAttribute("students", students);
        return "detailClass";
    }
    @RequestMapping(value = "/appUrl", method = RequestMethod.POST)
    public void test(@RequestBody String[] dataArrayToSend, HttpSession session) {
        for (String data : dataArrayToSend) {
            Student studentExist = studentRepository.findByStudentId(data);
            int classId = (Integer) session.getAttribute("classId") ;
                Optional<AptechClass> aptechClass = aptecClassRepository.findById(classId);
                AptechClass existAptechClass = new AptechClass();
            if (aptechClass != null) {
                existAptechClass = aptechClass.get();
                existAptechClass.getStudentSet().add(studentExist);
            }

                aptecClassRepository.save(existAptechClass);
            }
//            System.out.println("Your Data =>" + data);
        }
    }

