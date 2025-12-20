package com.LMS.LMS.userinformation.dto;

import com.LMS.LMS.role.UserRole;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserInfoDto {

    private Long id;
    private String fullName;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserRole userRole;
}


