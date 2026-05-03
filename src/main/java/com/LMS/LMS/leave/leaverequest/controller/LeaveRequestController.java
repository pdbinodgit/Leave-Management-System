package com.LMS.LMS.leave.leaverequest.controller;

import com.LMS.LMS.customresponse.ApiResponse;
import com.LMS.LMS.leave.leaverequest.dto.LeaveRequestDto;
import com.LMS.LMS.leave.leaverequest.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaveRequest")
public class LeaveRequestController {

    @Autowired
    LeaveRequestService leaveRequestService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveLeave(@RequestBody LeaveRequestDto leaveRequestDto){
        leaveRequestService.saveLeave(leaveRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(HttpStatus.OK,"Leave request save successfully",leaveRequestDto));

    }

}
