package com.LMS.LMS.userinformation.service;

import com.LMS.LMS.userinformation.dto.UserInfoDto;
import com.LMS.LMS.userinformation.model.UserInfo;

import java.util.List;

public interface UserInfoService {

    public UserInfoDto saveUserInfo(UserInfoDto dto);

    public List<UserInfoDto> getAllUser();

}
