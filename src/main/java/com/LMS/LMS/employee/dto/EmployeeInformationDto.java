package com.LMS.LMS.employee.dto;

import com.LMS.LMS.userinformation.model.UserInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeInformationDto {

    private UserInfo userInfo;

    private String firstName;

    private String middleName;

    private String lastName;

    private String employeeCode;

    private LocalDate contractStartDate;

    private LocalDate getContractEndDate;



}
