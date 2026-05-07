package com.LMS.LMS.util;

import com.LMS.LMS.auth.jwt.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserUtility {

    public Long getUserId(){
        Object principal=
                SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();
        if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).getUserId();
        }
        throw new RuntimeException("User not authenticated");
    }
    public String getUsername(){
        Object principal=
                SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();
        if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).getUsername();
        }
        throw new RuntimeException("User not authenticated");
    }

}
