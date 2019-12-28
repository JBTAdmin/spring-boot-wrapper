package com.jbt.springbootehcache.controller;

import com.jbt.springbootehcache.model.Person;
import com.jbt.springbootehcache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPagePerson(@RequestBody Person person) {
        Person person1 =  personService.createPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    @PutMapping("/person")
    public ResponseEntity<Person> editPersonData(@RequestBody Person person){
        Person person1 = personService.editPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.OK);
    }

    @DeleteMapping("/person")
    public ResponseEntity deletePerson(@RequestParam long id){
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}