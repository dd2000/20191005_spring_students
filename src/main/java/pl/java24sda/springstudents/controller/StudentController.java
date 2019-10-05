package pl.java24sda.springstudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.java24sda.springstudents.model.Student;
import pl.java24sda.springstudents.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/student/")   // teraz wszystkie metody adresowane są na: /student/add lub /student/list itd
            // jakby /student był lokalizacją bazową
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/delete/{student_to_remove}")
    public String usunStudenta(@PathVariable(name = "student_to_remove") Long id){
        studentService.deleteById(id);

        return "redirect:/student/list";
    }

    @GetMapping("/edit/{edited_student_id}")
    public String pobierzFormularzEdycji(Model model,
                                         @PathVariable(name = "edited_student_id") Long id){
        Optional<Student> studentOptional = studentService.findById(id); // wyszukaj w bazie rekord studenta
        if (studentOptional.isPresent()){   // jeśli jest rekord, to
            Student student = studentOptional.get();  // wydobywamy go z optional

            model.addAttribute("student_do_uzupelnienia", student);  // umieszczamy jako argument (do edycji)
            return "student-form";  // ładujemy formularz
        } else {
            return "redirect:/student/list";  // jeśli nie uda się go odnaleźć, wróć do listy
        }
    }

    @GetMapping("/add")
    public String zaladujFormularz(Model model){
        model.addAttribute("student_do_uzupelnienia", new Student());
        return "student-form"; /* nazwa strony  -- > zwracana do przeglądarki */
    }

    @PostMapping("/add")
    public String zapisz(Student student){
        studentService.save(student);

        return "redirect:/student/list";
    }



//  @RequestMapping(path = "/list, method = RequestMethod.Get")  // odpowiednik GetMapping
    @GetMapping("/list")
    public String wyswietlListeStudentow(Model model){
        // model to obiekt, który pozwala pokazywać parametry widoku
        // model posiada mapę atrybutów

        //List<Student> listaStudentow = new ArrayList<>();  // było tymczasowo !!!
        List<Student> listaStudentow = studentService.getAll();

        model.addAttribute("nasza_lista_studentow", listaStudentow); /* umieszczamy liste studentow z bazy danych */

        return "student-list"; /* nazwa pliku HTML */
    }
}
