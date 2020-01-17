package com.jbt.springbootmongodb.service;

import com.jbt.springbootmongodb.model.Person;
import com.jbt.springbootmongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person editPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}