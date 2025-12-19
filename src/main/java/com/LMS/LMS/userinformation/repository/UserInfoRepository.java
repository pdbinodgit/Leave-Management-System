package com.LMS.LMS.userinformation.repository;

import com.LMS.LMS.userinformation.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    public Optional<UserInfo> findByUsername(String username);
}
