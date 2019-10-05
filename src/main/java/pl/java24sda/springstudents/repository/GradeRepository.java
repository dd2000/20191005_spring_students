package pl.java24sda.springstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.java24sda.springstudents.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

}
