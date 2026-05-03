package com.LMS.LMS.leaverequest.service;

import com.LMS.LMS.leaverequest.dto.LeaveRequestDto;
import com.LMS.LMS.status.LeaveStatus;

import java.util.List;

public interface LeaveRequestService {

    public LeaveRequestDto saveLeave(LeaveRequestDto leaveRequestDto);

    public List<LeaveRequestDto> findAllLeaveRequest();

    public List<LeaveRequestDto> findAllByStatus(LeaveStatus status);

    public List<LeaveRequestDto> findAllActiveLeave();
}
