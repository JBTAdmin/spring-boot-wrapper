package com.jbt.nosql.controller;

import com.jbt.nosql.model.Person;
import com.jbt.nosql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

  @RequestMapping(value = "/person", method = RequestMethod.GET)
  @GetMapping
  public String getAllPerson(Model model) {
    model.addAttribute("persons", personService.getAllPersons());
    return "CRUD";
  }

  @RequestMapping(value = "/person", method = RequestMethod.POST)
  @PostMapping
  public String addPagePerson(@ModelAttribute Person person, Model model) {
    personService.createPerson(person);
    model.addAttribute("persons", personService.getAllPersons());
    return "CRUD";
  }

  @PostMapping("/edit")
  public Person editPersonData(@RequestBody Person person) {
    return personService.editPerson(person);
  }

  @PostMapping("/delete")
  public void deletePerson(@RequestParam String id) {
    personService.deletePerson(id);
  }
}
