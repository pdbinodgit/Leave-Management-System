package com.LMS.LMS.leave.leavebalance.repository;

import com.LMS.LMS.leave.leavebalance.model.LeaveBalance;
import org.hibernate.sql.ast.tree.expression.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance,Long> {

    Optional<LeaveBalance> findByEmployee_IdAndLeaveType_IdAndPresentStatus(long userId,long leaveId,boolean status);
    List<LeaveBalance> findByEmployee_IdAndPresentStatusAndYear(long userId, boolean status, String year);
    Optional<LeaveBalance> findByEmployee_IdAndPresentStatusAndYearAndLeaveType_Id(long employeeId, boolean status, String year, long leaveId);

}
