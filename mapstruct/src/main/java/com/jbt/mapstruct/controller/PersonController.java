package com.jbt.mapstruct.controller;

import com.jbt.mapstruct.domain.PersonDto;
import com.jbt.mapstruct.entity.Person;
import com.jbt.mapstruct.service.PersonService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping()
  public Person get(@RequestBody PersonDto personDto) {
    return personService.get(personDto);
  }

  @PostMapping("toDto")
  public PersonDto get(@RequestBody Person person) {
    return personService.get(person);
  }
}
