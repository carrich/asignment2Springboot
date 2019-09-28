package fpt.asignmentspringboot.service;

import fpt.asignmentspringboot.entity.AptechClass;
import fpt.asignmentspringboot.entity.Student;
import fpt.asignmentspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AptechClazzRepository aptechClazzRepository;
    @Override
    public void save(Student student, long classId) {
        Optional<Student> student1 = studentRepository.findById(student.getId());
        if (student1 != null) {
         Student   studentExist = student1.get();
            AptechClass aptechClass = aptechClazzRepository.findById(classId);
            aptechClass.getStudentSet().add(studentExist);
            aptechClazzRepository.save(aptechClass);
        }
    }

    @Override
    public Student luu(Student student) {
        student.setId(Calendar.getInstance().getTimeInMillis());
        studentRepository.save(student);
        Student savedStudent = studentRepository.findByStudentId(student.getStudentId());
        return savedStudent;
    }

    @Override
    public Student findByEmailAndPassword(String email, String password) {
        Student student = studentRepository.findByEmailAndPasword(email, password);
        return student;
    }
}
