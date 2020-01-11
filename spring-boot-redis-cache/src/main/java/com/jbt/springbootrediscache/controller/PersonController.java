package com.jbt.springbootrediscache.controller;

import com.jbt.springbootrediscache.model.Person;
import com.jbt.springbootrediscache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id){
        return new ResponseEntity(personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person person1 =  personService.createPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Person> editPerson(@RequestBody Person person){
        Person person1 = personService.editPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deletePerson(@RequestParam long id){
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}