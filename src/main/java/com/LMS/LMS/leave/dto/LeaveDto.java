package com.LMS.LMS.leave.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
public class LeaveDto {

    private Long id;
    private String leaveType;

    private Long totalLeave;

    private Boolean presentStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
