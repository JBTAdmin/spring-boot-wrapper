package com.jbt.mapstruct.controller;

import com.jbt.mapstruct.domain.CustomerDto;
import com.jbt.mapstruct.entity.Customer;
import com.jbt.mapstruct.service.CustomerService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping()
  public Customer get(@RequestBody CustomerDto customerDto) {
    return customerService.get(customerDto);
  }

  @PostMapping("toDto")
  public CustomerDto get(@RequestBody Customer customer) {
    return customerService.get(customer);
  }
}
