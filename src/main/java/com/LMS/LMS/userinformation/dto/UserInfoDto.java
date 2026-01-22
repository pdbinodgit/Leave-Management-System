package com.LMS.LMS.userinformation.dto;

import com.LMS.LMS.role.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

    private Long id;
    private String fullName;
    private String username;
    private String password;
    private UserRole userRole;
}


