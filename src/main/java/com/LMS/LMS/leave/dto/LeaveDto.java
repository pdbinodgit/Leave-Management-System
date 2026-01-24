package com.LMS.LMS.leave.dto;

import lombok.Getter;
import lombok.Setter;

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
