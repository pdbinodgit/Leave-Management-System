package com.LMS.LMS.leave.leavebalance.dto;

import com.LMS.LMS.employee.dto.EmployeeInformationDto;
import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.leaveinformation.dto.LeaveDto;
import com.LMS.LMS.leave.leaveinformation.model.LeaveInformation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveBalanceDto {

    private Long id;
    private EmployeeInformationDto employee;
    private LeaveDto leaveType;
    private int totalAllowed;
    private int used;
    private int remaining;
}
