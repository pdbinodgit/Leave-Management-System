package com.LMS.LMS.userinformation.controller;

import com.LMS.LMS.customresponse.ApiResponse;
import com.LMS.LMS.userinformation.dto.UserInfoDto;
import com.LMS.LMS.userinformation.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @Autowired
    public UserInfoService userInfoService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveUser(@RequestBody UserInfoDto dto){
        userInfoService.saveUserInfo(dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User created successfully"));
    }
}
