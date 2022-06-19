package com.jbt.springboot.service;

import com.jbt.springboot.entity.Person;
import com.jbt.springboot.handler.PersonNotFoundException;
import com.jbt.springboot.model.PersonDto;
import com.jbt.springboot.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  @Override
  public Person savePerson(PersonDto personDto) {
    return personRepository.save(mapPerson(personDto));
  }

  @Override
  public Optional<Person> getPerson(UUID id) {
    return personRepository.findById(id);
  }

  @Override
  public Person updatePerson(Person person) {
    return personRepository.save(person);
  }

  @Override
  public void deletePersonByNameAndAge(PersonDto personDto) {
    personRepository.deletePersonByNameAndDob(personDto.getName(), personDto.getDob());
  }

  @Override
  public void deletePersonById(UUID id) {
    PersonDto.builder().oneAddress().address("again").build();

    if (personRepository.existsById(id)) {
      personRepository.deleteById(id);
    } else {
      throw new PersonNotFoundException(id);
    }
  }

  @Override
  public List<Person> getAllPersons(int pageNumber, int pageSize) {
    return personRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
  }

  @Override
  public List<PersonDto> getAllPersons() {
    List<Person> person = personRepository.findAll();
    return person.stream().map(PersonDto::new).collect(Collectors.toList());
  }

  private Person mapPerson(PersonDto personDto) {
    return Person.builder()
        .name(personDto.getName())
        .address(personDto.getAddress())
        .qualification(personDto.getQualification())
        .dob(personDto.getDob())
        .height(personDto.getHeight())
        .gender(personDto.getGender())
        .build();
  }

}
