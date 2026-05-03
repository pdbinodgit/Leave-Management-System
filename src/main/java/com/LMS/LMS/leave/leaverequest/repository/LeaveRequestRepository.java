package com.LMS.LMS.leaverequest.repository;

import com.LMS.LMS.leaverequest.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {

    boolean existsByEmployeeIdAndPresentStatusAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long id, boolean presentDate, LocalDate startDate,LocalDate endDate
    );
}
