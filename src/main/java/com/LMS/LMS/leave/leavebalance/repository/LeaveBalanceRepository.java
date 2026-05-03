package com.LMS.LMS.leavebalance.repository;

import com.LMS.LMS.leavebalance.model.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance,Long> {

    Optional<LeaveBalance> findByEmployee_IdAndLeaveType_IdAndPresentStatus(long userId,long leaveId,boolean status);

}
