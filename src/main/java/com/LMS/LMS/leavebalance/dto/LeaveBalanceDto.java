package com.LMS.LMS.leavebalance.dto;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.model.LeaveInformation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveBalanceDto {

    private Long id;
    private EmployeeInformation employee;
    private LeaveInformation leaveType;
    private int totalAllowed;
    private int used;
    private int remaining;
}
