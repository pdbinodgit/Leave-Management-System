package com.LMS.LMS.leave.controller;

import com.LMS.LMS.customresponse.ApiResponse;
import com.LMS.LMS.leave.dto.LeaveDto;
import com.LMS.LMS.leave.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 @RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveLeave(@RequestBody LeaveDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Leave save successfully",leaveService.saveLeave(dto)));
    }

    @GetMapping("/findAll")
    public ResponseEntity<ApiResponse<?>> findAllLeave(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Leave retrieve successfully.",leaveService.findAllLeave()));

    }

    @GetMapping("/findByStatus")
    public ResponseEntity<ApiResponse<?>> findByStatus(@RequestParam boolean status){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Leave retrieve successfully.",leaveService.findByStatus(status)));

    }
     @GetMapping("/findByLeaveName")

    public ResponseEntity<ApiResponse<?>> findByLeaveType(@RequestParam String leave){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Leave retrieve successfully.",leaveService.findByLeaveType(leave)));

    }
}
