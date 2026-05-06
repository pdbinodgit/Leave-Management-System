package com.LMS.LMS.leave.leaverequest.dto;

import com.LMS.LMS.employee.dto.EmployeeInformationDto;
import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.leaveinformation.dto.LeaveDto;
import com.LMS.LMS.leave.leaveinformation.model.LeaveInformation;
import com.LMS.LMS.status.LeaveStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LeaveRequestDto {
    private Long id;
    private EmployeeInformationDto employee;
    private LeaveDto leaveInformation;
    private LocalDate startDate;
    private LocalDate endDate;
    private long totalTakenDays;
    private LeaveStatus leaveStatus;
    private boolean presentStatus;
}
