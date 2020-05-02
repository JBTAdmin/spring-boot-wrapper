package com.jbt.springbootredis.controller;

import com.jbt.springbootredis.model.Person;
import com.jbt.springbootredis.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public ResponseEntity<List<Person>> getPersons() {
    List<Person> persons = personService.getAllPersons();
    return new ResponseEntity<>(persons, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable long id) {
    return new ResponseEntity(personService.getPerson(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Person> addPerson(@RequestBody Person person) {
    Person person1 = personService.createPerson(person);
    return new ResponseEntity<>(person1, HttpStatus.CREATED);
  }
}
