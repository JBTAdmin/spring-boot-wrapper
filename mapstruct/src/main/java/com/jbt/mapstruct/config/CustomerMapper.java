package com.jbt.mapstruct.config;

import com.jbt.mapstruct.domain.CustomerDto;
import com.jbt.mapstruct.entity.Customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// TODO department Mapper when in this class doesnt work.
// @Mapper(uses = {DepartmentMapper.class, DateMapper.class})
@Mapper(uses = {DepartmentMapper.class})
public interface CustomerMapper {

  @Mappings({
    @Mapping(source = "name", target = "customerName"),
    @Mapping(source = "dob", target = "dob", dateFormat = "dd/MM/yyyy")
  })
  CustomerDto customerToCustomerDto(Customer customer);

  @Mapping(source = "customerName", target = "name")
  Customer customerDtoToCustomer(CustomerDto customerDto);
}
