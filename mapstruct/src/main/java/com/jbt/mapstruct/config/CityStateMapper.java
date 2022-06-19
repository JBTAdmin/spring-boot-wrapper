package com.jbt.mapstruct.config;

import com.jbt.mapstruct.domain.City;
import com.jbt.mapstruct.entity.State;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper
public interface CityStateMapper {

  @ValueMappings({
    @ValueMapping(source = "BANGALORE", target = "KA"),
    @ValueMapping(source = "MUMBAI", target = "MH"),
    @ValueMapping(source = "CHENNAI", target = "OTHER")
  })
  State cityToState(City city);

  //  City stateToCity(State state);
}
