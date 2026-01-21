package com.LMS.LMS.mapper;

import com.LMS.LMS.employee.dto.EmployeeInformationDto;
import com.LMS.LMS.employee.model.EmployeeInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeInformationMapping {
    public EmployeeInformationDto entityToDto(EmployeeInformation empInfo);
    public EmployeeInformation dtoToEntity(EmployeeInformationDto dto);
}
