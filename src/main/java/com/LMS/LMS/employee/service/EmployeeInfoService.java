package com.LMS.LMS.employee.service;

import com.LMS.LMS.employee.dto.EmployeeInformationDto;

import java.util.List;

public interface EmployeeInfoService {

    public EmployeeInformationDto saveEmployeeInformation(EmployeeInformationDto dto);

    public List<EmployeeInformationDto> findAllEmployee();

    public EmployeeInformationDto findByEmployeeCode(String code);

}
