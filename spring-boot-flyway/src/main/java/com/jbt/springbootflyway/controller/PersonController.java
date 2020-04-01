package com.jbt.springbootflyway.controller;

import com.jbt.springbootflyway.model.Person;
import com.jbt.springbootflyway.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<String> getPerson(@PathVariable long id){
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPersons(){
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }
}