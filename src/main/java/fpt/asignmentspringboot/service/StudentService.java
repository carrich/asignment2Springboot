package fpt.asignmentspringboot.service;

import fpt.asignmentspringboot.entity.Student;

public interface StudentService {
    public void save(Student student, long classId);

    public Student luu(Student student);

    public Student findByEmailAndPassword(String email, String password);
}
