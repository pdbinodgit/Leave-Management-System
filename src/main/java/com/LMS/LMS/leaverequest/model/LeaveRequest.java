package com.LMS.LMS.leaverequest.model;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.model.LeaveInformation;
import com.LMS.LMS.status.LeaveStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "leave_request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeInformation employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_information_id", nullable = false)
    private LeaveInformation leaveInformation;

    private LocalDate startDate;

    private LocalDate endDate;

    private long totalTakenDays;

    private LeaveStatus leaveStatus;

    private boolean presentStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
