package pl.java24sda.springstudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.java24sda.springstudents.service.GradeService;

@Controller
@RequestMapping(path = "/grade/")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/grade/list")
    public String listGrades(Model model){
        model.addAttribute("grades", gradeService.getAll());

        return "grade-list";
    }
}
