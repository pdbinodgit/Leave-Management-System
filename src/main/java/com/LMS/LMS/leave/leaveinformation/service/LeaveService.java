package com.LMS.LMS.leaveinformation.service;

import com.LMS.LMS.leaveinformation.dto.LeaveDto;

import java.util.List;

public interface LeaveService {

    public LeaveDto saveLeave(LeaveDto dto);

    public List<LeaveDto> findAllLeave();

    public List<LeaveDto> findByStatus(boolean status);

    public LeaveDto findByLeaveType(String leave);
}
