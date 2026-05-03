package com.LMS.LMS.leave.leaveinformation.repository;

import com.LMS.LMS.leave.leaveinformation.model.LeaveInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LeaveRepo extends JpaRepository<LeaveInformation,Long> {

    public List<LeaveInformation> findByPresentStatus(boolean status);
    public Optional<LeaveInformation> findByIdAndPresentStatus(long id,boolean status);


    public Optional<LeaveInformation> findByLeaveTypeAndPresentStatus(String name,boolean status);
}
