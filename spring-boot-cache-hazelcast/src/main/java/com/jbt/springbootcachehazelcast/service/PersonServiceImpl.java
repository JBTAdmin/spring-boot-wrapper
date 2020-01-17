package com.jbt.springbootcachehazelcast.service;

import com.jbt.springbootcachehazelcast.model.Person;
import com.jbt.springbootcachehazelcast.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Cacheable("person")
    @Override
    public String getPerson(Long id) {
        System.out.println("inside the method. Means caching is not HIT");
        return personRepository.findById(1l).get().getName();
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

//    @Cacheable("persons")
    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
