package com.LMS.LMS.leave.leavebalance.controller;

import com.LMS.LMS.leave.leavebalance.dto.LeaveBalanceDto;
import com.LMS.LMS.leave.leavebalance.model.LeaveBalance;
import com.LMS.LMS.leave.leavebalance.service.LeaveBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leaveBalance")
public class LeaveBalanceController {
    @Autowired
    LeaveBalanceService  leaveBalanceService;

    @GetMapping("/myLeave")
    public List<LeaveBalanceDto> findMyLeaveBalance(){
       return leaveBalanceService.findMyLeaveBalance();
    }
}
