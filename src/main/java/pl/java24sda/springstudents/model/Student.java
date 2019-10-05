package pl.java24sda.springstudents.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @Formula(value = "(year(now())-year(date_of_birth))" )  // adnotacja FORMULAto nie jest pole BD, tylko wartość wyliczana
    private int age;

    private boolean isAlive;

    public Student(String name, String surname, LocalDate dateOfBirth, int age) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public Student(String name, String surname, LocalDate dateOfBirth, boolean isAlive) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.isAlive = isAlive;
    }
}
