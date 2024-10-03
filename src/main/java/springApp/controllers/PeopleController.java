package springApp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springApp.DAO.PeopleDAO;
import springApp.models.Person;

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

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleDAO.read(id));
        return "/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/create";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        peopleDAO.create(person);
        return "redirect:/people";
    }

}
