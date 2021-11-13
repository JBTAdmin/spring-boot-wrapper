package com.jbt.config;

import com.jbt.manager.oracle.entity.Customer;
import com.jbt.model.CustomerDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	CustomerDto customerToCustomerDto(Customer customer);
	Customer customerDtoToCustomer(CustomerDto customerDto);
}
