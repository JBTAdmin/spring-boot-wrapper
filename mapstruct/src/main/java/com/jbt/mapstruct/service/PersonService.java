package com.jbt.mapstruct.service;

import com.jbt.mapstruct.config.PersonMapper;
import com.jbt.mapstruct.domain.PersonDto;
import com.jbt.mapstruct.entity.Person;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  public PersonDto get(Person person) {
    return INSTANCE.personToPersonDto(person);
  }

  public Person get(PersonDto personDto) {
    return INSTANCE.personDtoToPerson(personDto);
  }
}
