package fpt.asignmentspringboot.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AptechClass {
    @Id
    private int id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "aptech_class_student",
            joinColumns = @JoinColumn(name = "aptech_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> studentSet;

    public AptechClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
