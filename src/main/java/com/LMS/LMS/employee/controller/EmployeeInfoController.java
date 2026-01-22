package com.LMS.LMS.employee.controller;

import com.LMS.LMS.customresponse.ApiResponse;
import com.LMS.LMS.employee.dto.EmployeeInformationDto;
import com.LMS.LMS.employee.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class EmployeeInfoController {

    @Autowired
    EmployeeInfoService employeeInfoService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveEmployeeInformation(@RequestBody EmployeeInformationDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Employee created successfully",employeeInfoService.saveEmployeeInformation(dto)));
    }
    @GetMapping("/findAll")
    public ResponseEntity<ApiResponse<?>> findAllEmployee(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Employee information retrieve successfully",employeeInfoService.findAllEmployee()));

    }

    @GetMapping("/findByCode")
    public ResponseEntity<ApiResponse<?>> findByEmployeeCode(@RequestParam String code){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Employee information retrieve successfully",employeeInfoService.findByEmployeeCode(code)));

    }
}
