package com.LMS.LMS.leave.leaverequest.repository;

import com.LMS.LMS.leave.leaverequest.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {

    boolean existsByEmployeeIdAndPresentStatusAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long id, boolean presentDate, LocalDate startDate,LocalDate endDate
    );
}
