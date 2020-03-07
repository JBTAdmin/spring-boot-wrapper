package com.jbt.microserviceapplication.controller;


import com.jbt.microserviceapplication.entity.Email;
import com.jbt.microserviceapplication.entity.Person;
import com.jbt.microserviceapplication.model.PersonDto;
import com.jbt.microserviceapplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public ResponseEntity<String> getPerson(){
//        List<Person> persons = ;
        return new ResponseEntity(personService.getPerson(9l), HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons(){
//        List<Person> persons = ;
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPagePerson(@RequestBody PersonDto person) {
        Person person1 =  personService.createPerson(mapPerson(person));
        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    Person mapPerson(PersonDto personDto){
         Person person = Person.builder().age(personDto.getAge()).name(personDto.getName())
//                .email(List.of(Email.builder().emailId("First").build(),
//                        Email.builder().emailId(
//                        "First").build()))
                .build();
        person.addEmail((Email.builder().emailId("@Gmail.com").build()));
         return person;
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