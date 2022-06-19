package com.jbt.mapstruct.service;

import com.jbt.mapstruct.config.CustomerMapper;
import com.jbt.mapstruct.domain.CustomerDto;
import com.jbt.mapstruct.entity.Customer;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  public Customer get(CustomerDto customerDto) {
    return INSTANCE.customerDtoToCustomer(customerDto);
  }

  public CustomerDto get(Customer customer){
    return INSTANCE.customerToCustomerDto(customer);
  }
}
