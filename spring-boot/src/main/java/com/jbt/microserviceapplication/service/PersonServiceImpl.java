package com.jbt.microserviceapplication.service;

import com.jbt.microserviceapplication.entity.Person;
import com.jbt.microserviceapplication.repository.PersonRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
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
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAllPersons(int pageNumber, int pageSize) {
        return personRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
