package com.LMS.LMS.leave.leavebalance.service;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.leavebalance.dto.LeaveBalanceDto;
import com.LMS.LMS.leave.leavebalance.model.LeaveBalance;

import java.util.List;

public interface LeaveBalanceService {

    public void save(EmployeeInformation employeeInformation);

    public void updateLeaveBalance(long leaveId, long employeeId, long totalLeave);

    public List<LeaveBalanceDto> findMyLeaveBalance();
}
