package com.LMS.LMS.leave.leavebalance.controller;

import com.LMS.LMS.customresponse.ApiResponse;

import com.LMS.LMS.leave.leavebalance.service.LeaveBalanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/leaveBalance")
public class LeaveBalanceController {
    @Autowired
    LeaveBalanceService  leaveBalanceService;

    @GetMapping("/myLeave")
    public ResponseEntity<ApiResponse<?>> findMyLeaveBalance(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Leave retrieve successfully",leaveBalanceService.findMyLeaveBalance()));
    }


}
