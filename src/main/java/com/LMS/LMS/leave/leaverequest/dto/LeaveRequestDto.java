package com.LMS.LMS.leave.leaverequest.dto;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.leaveinformation.model.LeaveInformation;
import com.LMS.LMS.status.LeaveStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LeaveRequestDto {
    private Long id;
    private EmployeeInformation employee;
    private LeaveInformation leaveInformation;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalTakenDays;
    private LeaveStatus leaveStatus;
    private boolean presentStatus;
}
