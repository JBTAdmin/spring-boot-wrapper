package com.jbt.mapstruct.config;

import com.jbt.mapstruct.domain.DepartmentDto;
import com.jbt.mapstruct.entity.Department;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface DepartmentMapper {

  @Mappings({
    @Mapping(source = "name", target = "departmentName"),
    @Mapping(source = "code", target = "departmentCode")
  })
  DepartmentDto departmentToDepartmentDto(Department department);

  @Mappings({
    @Mapping(source = "departmentName", target = "name"),
    @Mapping(source = "departmentCode", target = "code")
  })
  Department departmentDtoToDepartment(DepartmentDto departmentDto);
}
