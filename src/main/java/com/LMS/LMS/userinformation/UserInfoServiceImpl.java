package com.LMS.LMS.userinformation;

import com.LMS.LMS.userinformation.dto.UserInfoDto;
import com.LMS.LMS.exception.LmsException;
import com.LMS.LMS.userinformation.model.UserInfo;
import com.LMS.LMS.userinformation.repository.UserInfoRepository;
import com.LMS.LMS.userinformation.service.UserInfoService;
import com.LMS.LMS.mapper.UserInfoMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public  class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserInfoMapping userInfoMapping;

    @Override
    public UserInfoDto saveUserInfo(UserInfoDto dto) {
        Optional<UserInfo> userNameCheck=userInfoRepository.findByUsername(dto.getUsername());
        if (userNameCheck.isPresent()){
            throw new LmsException("User already present", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }
        UserInfo userInfo=userInfoMapping.dtoToEntity(dto);
        UserInfo info=userInfoRepository.save(userInfo);
        return userInfoMapping.entityToDto(info);
    }

    @Override
    public List<UserInfoDto> getAllUser() {

        List<UserInfo> userInfoList=userInfoRepository.findAll();
        List<UserInfoDto> dtoList=new ArrayList<>();
        for(UserInfo userInfo:userInfoList){
            System.out.println("user id "+userInfo.getId());
           dtoList.add(userInfoMapping.entityToDto(userInfo));
        }
        return dtoList;
    }
}
