package com.LMS.LMS.employee.repository;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.userinformation.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeInfoRepo extends JpaRepository<EmployeeInformation,Long> {

    public Optional<EmployeeInformation> findByEmployeeCode(String code);

    public boolean existsByEmployeeCode(String code);

    public boolean existsByUserInfo(UserInfo info);

    public Optional<EmployeeInformation> findByUserInfo_username(String username);
}
