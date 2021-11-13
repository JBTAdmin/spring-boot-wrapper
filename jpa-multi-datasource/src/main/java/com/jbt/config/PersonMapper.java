package com.jbt.config;

import com.jbt.manager.mysql.entity.Person;
import com.jbt.model.PersonDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonMapper {
//	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

	@Mapping(source = "name", target = "personName")
	PersonDto personToPersonDto(Person person);

	@Mapping(source = "personName", target = "name")
	Person PersonDtoToPerson(PersonDto personDto);
}
