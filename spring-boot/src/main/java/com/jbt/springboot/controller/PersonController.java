package com.jbt.springboot.controller;

import com.jbt.springboot.entity.Person;
import com.jbt.springboot.model.PersonDto;
import com.jbt.springboot.service.PersonService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/persons")
public class PersonController {

  private final PersonService personService;

  @GetMapping
  public List<PersonDto> getAllPerson() {
    return personService.getAllPersons();
  }

  @GetMapping("{id}")
  public Person getPerson(@PathVariable UUID id) {
    return personService
        .getPerson(id)
        .orElseThrow(
            () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "No Person found with given ID"));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Person addPerson(@RequestBody @Valid PersonDto personDto) {
    return personService.savePerson(personDto);
  }

  @PutMapping("/{id}")
  public Person editPerson(@RequestBody PersonDto personDto, @PathVariable UUID id) {

    return personService
        .getPerson(id)
        .map(
            person -> {
              person.setHeight(personDto.getHeight());
              return personService.updatePerson(person);
            })
        .orElseGet(() -> personService.savePerson(personDto));
  }

  @DeleteMapping("/{id}")
  public void deletePerson(@PathVariable UUID id) {
    personService.deletePersonById(id);
  }

  @DeleteMapping
  public void deletePerson(@RequestBody PersonDto person) {
    personService.deletePersonByNameAndAge(person);
  }
}
