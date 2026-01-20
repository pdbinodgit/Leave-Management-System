package com.LMS.LMS.userinformation;

import com.LMS.LMS.role.UserRole;
import com.LMS.LMS.userinformation.dto.UserInfoDto;
import com.LMS.LMS.exception.LmsException;
import com.LMS.LMS.userinformation.model.UserInfo;
import com.LMS.LMS.userinformation.repository.UserInfoRepository;
import com.LMS.LMS.userinformation.service.UserInfoService;
import com.LMS.LMS.mapper.UserInfoMapping;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public  class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserInfoMapping userInfoMapping;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserInfoDto saveUserInfo(UserInfoDto dto) {
        Optional<UserInfo> userNameCheck=userInfoRepository.findByUsername(dto.getUsername());
        if (userNameCheck.isPresent()){
            throw new LmsException("User already present", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }

        UserInfo userInfo=userInfoMapping.dtoToEntity(dto);
        userInfo.setPassword(encoder.encode(dto.getPassword()));
        UserInfo info=userInfoRepository.save(userInfo);
        return userInfoMapping.entityToDto(info);
    }

    @Override
    public List<UserInfoDto> getAllUser() {

        List<UserInfo> userInfoList=userInfoRepository.findAll();
        List<UserInfoDto> dtoList=new ArrayList<>();
        for(UserInfo userInfo:userInfoList){
           dtoList.add(userInfoMapping.entityToDto(userInfo));
        }
        return dtoList;
    }


    @PostConstruct
    public void saveAdminUser(){
        List<UserInfo> userInfoList=userInfoRepository.findAll();
        if (userInfoList.isEmpty()){
            UserInfo userInfo=new UserInfo();
            userInfo.setFullName("Bishnu Prasad Pandey");
            userInfo.setUsername("pandeybinod2075@gmail.com");
            userInfo.setPassword(encoder.encode("binod@lms"));
            userInfo.setCreatedAt(LocalDateTime.now());
            userInfo.setUserRole(UserRole.ADMIN);
            userInfoRepository.save(userInfo);
        }
    }
}
