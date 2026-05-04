package com.LMS.LMS.employee.dto;

import com.LMS.LMS.userinformation.model.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeInformationDto {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserInfo userInfo;

    private String firstName;

    private String middleName;

    private String lastName;

    private String employeeCode;

    private LocalDate contractStartDate;

    private LocalDate contractEndDate;



}
