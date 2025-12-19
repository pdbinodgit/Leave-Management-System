package com.LMS.LMS.mapper;

import com.LMS.LMS.userinformation.dto.UserInfoDto;
import com.LMS.LMS.userinformation.model.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapping {

    public UserInfoDto entityToDto(UserInfo userInfo);
    public UserInfo dtoToEntity(UserInfoDto userInfoDto);
}
