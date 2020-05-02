package com.jbt.springbootehcache.controller;

import com.jbt.springbootehcache.model.Person;
import com.jbt.springbootehcache.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @GetMapping("{id}")
  public Person getPerson(@PathVariable long id) {
    return personService.getPerson(id).get();
  }

  @GetMapping
  public ResponseEntity<List<Person>> getAllPerson() {
    return new ResponseEntity<>(personService.getAllPerson(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Person> addPerson(@RequestBody Person person) {
    Person person1 = personService.addPerson(person);
    return new ResponseEntity<>(person1, HttpStatus.CREATED);
  }

  @PutMapping
  public Person updatePerson(@RequestBody Person person) {
    Person person1 = personService.updatePerson(person);
    return person1;
  }

  @DeleteMapping("/id")
  public void deletePerson(@PathVariable long id) {
    personService.deletePerson(id);
  }
}
