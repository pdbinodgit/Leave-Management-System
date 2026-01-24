package com.LMS.LMS.leave.repository;

import com.LMS.LMS.leave.model.LeaveInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LeaveRepo extends JpaRepository<LeaveInformation,Long> {

    public Optional<LeaveInformation> findByPresentStatus(boolean status);

    public Optional<LeaveInformation> findByLeaveTypeAndPresentStatus(String name,boolean status);
}
