package springApp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springApp.DAO.PeopleDAO;

@Controller
@RequestMapping("/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleController {
    private final PeopleDAO peopleDAO;

    @GetMapping
    public String people(Model model) {
        model.addAttribute("people", peopleDAO.read());
        return "people";
    }



}
