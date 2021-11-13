package com.jbt.controller;

import com.jbt.model.CustomerDto;
import com.jbt.service.DbService;

import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class CustomerController {

  private final DbService dbService;

  @Autowired
  public CustomerController(DbService dbService) {
    this.dbService = dbService;
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<String> getCustomer(@PathVariable UUID id) {
    return new ResponseEntity(dbService.getCustomer(id), HttpStatus.OK);
  }

  @GetMapping("/customer")
  public ResponseEntity<List<CustomerDto>> getAllCustomer() {
    return new ResponseEntity<>(dbService.getAllCustomer(), HttpStatus.OK);
  }

  @PostMapping("/customer")
  public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
    CustomerDto customer = dbService.createCustomer(customerDto);

    return new ResponseEntity<>(customer, HttpStatus.CREATED);
  }

//  @PutMapping("/customer")
//  public ResponseEntity<Person> editPerson(@RequestBody CustomerDto personDto) {
//    ;
//    log.info(
//        "Creating a customer Object With name {}, age {}",
//        personDto.getName(),
//        personDto.getGender());
//    return new ResponseEntity(dbService.editPerson(personDto), HttpStatus.OK);
//  }

//  @DeleteMapping("/customer/{id}")
//  public ResponseEntity deletePerson(@PathVariable long id) {
//    dbService.deletePersonById(id);
//    return new ResponseEntity<>(HttpStatus.OK);
//  }
}
