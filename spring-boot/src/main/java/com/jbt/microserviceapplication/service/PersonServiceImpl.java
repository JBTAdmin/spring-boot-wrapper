package com.jbt.microserviceapplication.service;

import com.jbt.microserviceapplication.model.Person;
import com.jbt.microserviceapplication.repository.Person1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private Person1Repository person1Repository;

    @Override
    public Person createPerson(Person person) {
        return person1Repository.save(person);
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return person1Repository.findById(id);
    }

    @Override
    public Person editPerson(Person person) {
        return person1Repository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        person1Repository.delete(person);
    }

    @Override
    public void deletePerson(Long id) {
        person1Repository.deleteById(id);
    }

    @Override
    public List<Person> getAllPersons(int pageNumber, int pageSize) {
        return person1Repository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public List<Person> getAllPersons() {
        return person1Repository.findAll();
    }
}
