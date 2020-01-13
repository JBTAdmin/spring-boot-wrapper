package com.jbt.springbootredis.service;

import com.jbt.springbootredis.model.Person;
import com.jbt.springbootredis.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        personRepository.save(person);
        return null;
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll().values().stream().collect(Collectors.toList());
    }
}