package com.jbt.microserviceapplication.service;

import com.jbt.microserviceapplication.entity.Email;
import com.jbt.microserviceapplication.entity.Person;
import com.jbt.microserviceapplication.model.PersonDto;
import com.jbt.microserviceapplication.repository.PersonRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(PersonDto personDto) {
        return personRepository.save(mapPerson(personDto));
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person editPerson(PersonDto personDto) {
        return personRepository.save(mapPerson(personDto));
    }

    @Override
    public void deletePersonByNameAndAge(PersonDto personDto) {
        personRepository.deletePersonByNameAndDob(personDto.getName(), personDto.getDob());
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAllPersons(int pageNumber, int pageSize) {
        return personRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> person = personRepository.findAll();
        return person.stream().map(person1 -> new PersonDto(person1)).collect(Collectors.toList());
    }

    private Person mapPerson(PersonDto personDto) {
        return Person.builder().name(personDto.getName())
                .address(personDto.getAddress())
                .qualification(personDto.getQualification())
                .dob(personDto.getDob())
                .gender(personDto.getGender())
//                .roles(personDto.getPersonRoles())
                .height(personDto.getHeight())
//                .email(
//                        personDto.getEmail().stream().map(Email::new).collect(Collectors.toList())
////                        personDto.getEmail().stream()
////                                .map(mailId -> Email.builder().emailId(mailId).build()).collect(Collectors.toList())
//                )
                .build();
    }
}