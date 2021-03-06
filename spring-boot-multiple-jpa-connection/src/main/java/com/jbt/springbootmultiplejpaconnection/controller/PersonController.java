package com.jbt.springbootmultiplejpaconnection.controller;

import com.jbt.springbootmultiplejpaconnection.manager.mysql.entity.Person;
import com.jbt.springbootmultiplejpaconnection.model.PersonDto;
import com.jbt.springbootmultiplejpaconnection.service.DbService;
import java.util.List;
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
@RequestMapping("/api")
public class PersonController {

  private final DbService dbService;

  @Autowired
  public PersonController(DbService dbService) {
    this.dbService = dbService;
  }

  @GetMapping("/person/{id}")
  public ResponseEntity<String> getPerson(@PathVariable Long id) {
    return new ResponseEntity(dbService.getPerson(id), HttpStatus.OK);
  }

  @GetMapping("/person")
  public ResponseEntity<List<PersonDto>> getAllPerson() {
    return new ResponseEntity<>(dbService.getAllPersons(), HttpStatus.OK);
  }

  @PostMapping("/person")
  public ResponseEntity<Person> addPerson(@RequestBody PersonDto personDto) {
    Person person = dbService.createPerson(personDto);
    log.info(
        "Creating a person Object With name {}, age {}",
        personDto.getName(),
        personDto.getGender());
    return new ResponseEntity<>(person, HttpStatus.CREATED);
  }

  @PutMapping("/person")
  public ResponseEntity<Person> editPerson(@RequestBody PersonDto personDto) {
    ;
    log.info(
        "Creating a person Object With name {}, age {}",
        personDto.getName(),
        personDto.getGender());
    return new ResponseEntity(dbService.editPerson(personDto), HttpStatus.OK);
  }

  @DeleteMapping("/person/{id}")
  public ResponseEntity deletePerson(@PathVariable long id) {
    dbService.deletePersonById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
