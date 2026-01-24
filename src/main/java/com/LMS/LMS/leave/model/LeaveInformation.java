package com.LMS.LMS.leave.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "leave_information")
@Getter
@Setter
public class LeaveInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "leave_type",nullable = false)
    private String leaveType;

    @Column(name = "total_leave",nullable = false)
    private Long totalLeave;

    @Column(nullable = false)
    private Boolean presentStatus = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
