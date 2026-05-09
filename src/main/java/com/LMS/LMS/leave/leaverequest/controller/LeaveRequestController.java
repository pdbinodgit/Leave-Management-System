package com.LMS.LMS.leave.leaverequest.controller;

import com.LMS.LMS.customresponse.ApiResponse;
import com.LMS.LMS.leave.leaverequest.dto.LeaveRequestDto;
import com.LMS.LMS.leave.leaverequest.service.LeaveRequestService;
import com.LMS.LMS.status.LeaveStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaveRequest")
public class LeaveRequestController {

    @Autowired
    LeaveRequestService leaveRequestService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveLeave(@RequestBody LeaveRequestDto leaveRequestDto) {
        leaveRequestService.saveLeave(leaveRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(HttpStatus.OK, "Leave request save successfully", leaveRequestDto));

    }

    @GetMapping("/findAllLeave")
    public ResponseEntity<ApiResponse<?>> findAllLeave() {
        List<LeaveRequestDto> list = leaveRequestService.findAllLeaveRequest();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(HttpStatus.OK, "Retrieve all leave request  successfully.", list));

    }

    @GetMapping("/findLeaveByActive")
    public ResponseEntity<ApiResponse<?>> findLeaveByActive(@RequestParam LeaveStatus status) {
        List<LeaveRequestDto> list = leaveRequestService.findAllByStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(HttpStatus.OK, "Retrieve all " + status + " leave request  successfully.", list));

    }

    @GetMapping("/myLeave")
    public ResponseEntity<ApiResponse<?>> myAllLeave() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(HttpStatus.OK, "Retrieve your all leave request  successfully.", leaveRequestService.myAllLeave()));
    }

    @GetMapping("/leaveForAuthentication")
    public ResponseEntity<ApiResponse<?>> leaveForAuthentication(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(HttpStatus.OK, "Retrieve all leave request  successfully.", leaveRequestService.leaveForAuthentication()));
    }

    @GetMapping("/updateLeaveRequest")
    public ResponseEntity<ApiResponse<?>> updateLeaveRequest(@RequestParam long leaveRequestId, @RequestParam LeaveStatus status) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(HttpStatus.OK, "Leave request update successfully.", leaveRequestService.updateLeaveRequest(leaveRequestId,status)));
    }



    }

