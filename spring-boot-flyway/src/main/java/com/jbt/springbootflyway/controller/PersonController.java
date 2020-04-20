package com.jbt.springbootflyway.controller;

import com.jbt.springbootflyway.model.Person;
import com.jbt.springbootflyway.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/{id}")
  public String getPerson(@PathVariable long id) {
    return personService.getPerson(id);
  }

  @GetMapping
  public List<Person> getPersons() {
    return personService.getAllPersons();
  }
}
