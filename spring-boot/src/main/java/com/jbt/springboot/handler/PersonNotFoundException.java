package com.jbt.springboot.handler;

public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException(Long id) {
    super("Person not found with id: " + id);
  }
}
