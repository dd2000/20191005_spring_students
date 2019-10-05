package pl.java24sda.springstudents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.java24sda.springstudents.model.Grade;
import pl.java24sda.springstudents.model.Student;
import pl.java24sda.springstudents.repository.GradeRepository;
import pl.java24sda.springstudents.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    public void save(Grade grade) {
        gradeRepository.save(grade);
    }

    public Optional<Grade> findById(Long id) {
        return gradeRepository.findById(id);
    }

    public void deleteById(Long id) {
        if (gradeRepository.existsById(id)){
            gradeRepository.deleteById(id);
        }
    }

}




