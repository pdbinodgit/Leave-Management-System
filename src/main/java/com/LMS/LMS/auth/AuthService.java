package com.LMS.LMS.auth;

import com.LMS.LMS.exception.LmsException;
import com.LMS.LMS.auth.jwt.JwtUtil;
import com.LMS.LMS.userinformation.model.UserInfo;
import com.LMS.LMS.userinformation.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    JwtUtil jwtUtil;

    public String  login(LoginRequest loginRequest){

        UserInfo userInfo=userInfoRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(()->new LmsException("User not found", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value()));

        if (!userInfo.getPassword().equals(loginRequest.getPassword())){
            throw new LmsException("Invalid user", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }
        if (!userInfo.getActive()){
            throw new LmsException("User is not active", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }
        return jwtUtil.generateToken(userInfo.getUsername());
    }
}
