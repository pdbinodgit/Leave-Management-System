package com.LMS.LMS.leaverequest.serviceImpl;

import com.LMS.LMS.leaverequest.dto.LeaveRequestDto;
import com.LMS.LMS.leaverequest.service.LeaveRequestService;
import com.LMS.LMS.status.LeaveStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
    @Override
    public LeaveRequestDto saveLeave(LeaveRequestDto leaveRequestDto) {
        return null;
    }

    @Override
    public List<LeaveRequestDto> findAllLeaveRequest() {
        return List.of();
    }

    @Override
    public List<LeaveRequestDto> findAllByStatus(LeaveStatus status) {
        return List.of();
    }

    @Override
    public List<LeaveRequestDto> findAllActiveLeave() {
        return List.of();
    }
}
