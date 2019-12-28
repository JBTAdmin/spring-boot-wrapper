package com.jbt.microserviceapplication.controller;

import com.jbt.microserviceapplication.model.Person;
import com.jbt.microserviceapplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("person", new Person());
        return "greeting";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @PostMapping
    public String addPagePerson(@ModelAttribute Person person, Model model) {
        personService.createPerson(person);
        model.addAttribute("persons", personService.getAllPersons());
        return "CRUD";
    }

    @PostMapping("/edit")
    public Person editPersonData(@RequestBody Person person){
        return personService.editPerson(person);
    }

    @PostMapping("/delete")
    public void deletePerson(@RequestParam long id){
        personService.deletePerson(id);
    }
}