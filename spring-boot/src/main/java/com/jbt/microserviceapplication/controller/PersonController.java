package com.jbt.microserviceapplication.controller;

import com.jbt.microserviceapplication.entity.Person;
import com.jbt.microserviceapplication.model.PersonDto;
import com.jbt.microserviceapplication.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<String> getPerson(@PathVariable Long id){
        return new ResponseEntity(personService.getPerson(id), HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<List<PersonDto>> getAllPerson(){
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody PersonDto personDto) {
        Person person =  personService.createPerson(personDto);
        log.info("Creating a person Object With name {}, age {}", personDto.getName(),
                personDto.getGender());
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/person")
    public ResponseEntity<Person> editPerson(@RequestBody PersonDto personDto){
        ;
        log.info("Creating a person Object With name {}, age {}", personDto.getName(),
                personDto.getGender());
        return new ResponseEntity(personService.editPerson(personDto), HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity deletePerson(@PathVariable long id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/person")
    public ResponseEntity deletePerson(@RequestBody PersonDto person){
        personService.deletePersonByNameAndAge(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}