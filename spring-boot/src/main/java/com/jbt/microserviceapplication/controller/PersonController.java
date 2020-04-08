package com.jbt.microserviceapplication.controller;

import com.jbt.microserviceapplication.entity.Person;
import com.jbt.microserviceapplication.model.PersonDto;
import java.util.List;
import com.jbt.microserviceapplication.service.PersonService;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getPerson(@PathVariable Long id){
        return new ResponseEntity(personService.getPerson(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPerson(){
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody PersonDto personDto) {
        Person person =  personService.createPerson(personDto);
        log.info("Creating a person Object With name {}, age {}", personDto.getName(),
                personDto.getGender());
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> editPerson(@RequestBody PersonDto personDto,
                                             @PathVariable long id) throws Exception {

        personService.getPerson(id).orElseThrow(() -> new Exception(
                "Person Object not found"));

        return new ResponseEntity(personService.editPerson(personDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable long id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deletePerson(@RequestBody PersonDto person){
        personService.deletePersonByNameAndAge(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}