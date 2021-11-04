package ua.lyubchenko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lyubchenko.model.Person;
import ua.lyubchenko.repositories.PersonRepositories;

@Controller
@RequestMapping("people")
public class PersonController {
    @Autowired
    private PersonRepositories personRepositories;


    @GetMapping()
    public String read(Model model) {
        model.addAttribute("people", personRepositories.getArrayList());
        return "read";
    }

    @GetMapping("{id}")
    public String getPersonById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personRepositories.getPersonById(id));
        return "person";
    }

    @GetMapping("new")
    public String addPerson(@ModelAttribute("person") Person person) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personRepositories.addPersonToRepository(person);
        return "redirect:people";
    }

    @GetMapping("{id}/update")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personRepositories.getPersonById(id));
        return "update";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personRepositories.update(id, person);
        return "redirect:people";
    }
}
