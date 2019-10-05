package pl.java24sda.springstudents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

//  @RequestMapping(path = "/list, method = RequestMethod.Get")  // odpowiednik GetMapping
    @GetMapping("/list")
    public String wyswietlListeStudentow(Model model){
        // model to obiekt, który pozwala pokazywać parametry widoku
        // model posiada mapę atrybutów

        model.addAttribute("nasza_lista_studentow", listaStudentow); /* umieszczamy liste studentow z bazy danych */

        return "student-list"; /* nazwa pliku HTML */
    }
}