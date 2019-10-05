package pl.java24sda.springstudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.java24sda.springstudents.model.Student;
import pl.java24sda.springstudents.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

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
