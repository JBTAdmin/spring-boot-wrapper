package com.jbt.springboot.handler;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException(UUID id) {
    super("Person not found with id: " + id);
  }
}
