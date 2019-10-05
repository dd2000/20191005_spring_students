package pl.java24sda.springstudents.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor  /* potrzebujemy dla hibernate */
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;

    private String surname;

    private LocalDate dateOfBirth;

    private int age;

    public Student(String name, String surname, LocalDate dateOfBirth, int age) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }
}
