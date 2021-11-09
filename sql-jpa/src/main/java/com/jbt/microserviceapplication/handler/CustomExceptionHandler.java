package com.jbt.microserviceapplication.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Global Exception Handler applied to all the controller. */
@ControllerAdvice
@ResponseBody
@Slf4j
public class CustomExceptionHandler {

  @ExceptionHandler({PersonNotFoundException.class, EmptyResultDataAccessException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String personNotFoundHandler(RuntimeException ex) {
    log.error("No Person with given id found");
    return ex.getMessage();
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  void nullPointerExceptionHandler(RuntimeException ex) {
    log.error("NullPointerException Thrown : " + ex.getStackTrace());
  }
}
