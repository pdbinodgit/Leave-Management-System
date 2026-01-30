package com.LMS.LMS.leavebalance.repository;

import com.LMS.LMS.leavebalance.model.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance,Long> {
}
