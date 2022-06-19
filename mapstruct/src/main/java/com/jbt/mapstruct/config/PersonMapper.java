package com.jbt.mapstruct.config;

import com.jbt.mapstruct.domain.PersonDto;
import com.jbt.mapstruct.entity.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PersonMapper {
  //	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  @Mappings({
    //    @Mapping(source = "name", target = "personName"),
    @Mapping(source = "name", target = "personName")
  })
  PersonDto personToPersonDto(Person person);

  @Mapping(source = "personName", target = "name")
  Person personDtoToPerson(PersonDto personDto);
}
