package pl.java24sda.springstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.java24sda.springstudents.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
