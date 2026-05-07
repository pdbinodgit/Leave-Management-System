package com.LMS.LMS.auth;

import com.LMS.LMS.customresponse.ApiResponse;
import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.employee.repository.EmployeeInfoRepo;
import com.LMS.LMS.leave.leavebalance.service.LeaveBalanceService;
import com.LMS.LMS.util.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    LeaveBalanceService leaveBalanceService;
    @Autowired
    EmployeeInfoRepo employeeInfoRepo;
    @Autowired
    UserUtility userUtility;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> login(@RequestBody LoginRequest loginRequest){
       String token= authService.login(loginRequest);
       LoginResponse loginResponse=new LoginResponse("User Login successfully",token);
        Optional<EmployeeInformation> employeeInformation=employeeInfoRepo.findByUserInfo_username(loginRequest.getUsername());
        employeeInformation.ifPresent(information -> leaveBalanceService.save(information));
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User Login successfully",loginResponse));
    }
}
