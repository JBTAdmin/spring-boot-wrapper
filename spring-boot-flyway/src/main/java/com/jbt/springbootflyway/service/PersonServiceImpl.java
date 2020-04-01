package com.jbt.springbootflyway.service;

import com.jbt.springbootflyway.model.Person;
import com.jbt.springbootflyway.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public String getPerson(Long id) {
        return personRepository.findById(id).get().getName();
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
