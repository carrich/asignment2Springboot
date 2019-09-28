package fpt.asignmentspringboot.repository;

import fpt.asignmentspringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findById(long id);

    Student findByStudentId(String studentId);

    Student findByEmailAndPasword(String email, String password);
}
