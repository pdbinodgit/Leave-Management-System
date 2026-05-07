package com.LMS.LMS.leave.leaverequest.repository;

import com.LMS.LMS.leave.leaverequest.model.LeaveRequest;
import com.LMS.LMS.status.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {

    @Query("select count(l)>0 from LeaveRequest l " +
            "where l.employee.id = :employeeId " +
            "AND l.presentStatus=:presentStatus " +
            "AND l.startDate <= :endDate " +
            "AND l.endDate >= :startDate" )
    boolean existsByEmployeeIdAndPresentStatusAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long employeeId, boolean presentStatus, LocalDate startDate,LocalDate endDate
    );

    List<LeaveRequest> findAllLeaveRequestByLeaveStatus(LeaveStatus leaveStatus);

    List<LeaveRequest> findAllLeaveRequestByEmployee_Id(long employeeId);
}
