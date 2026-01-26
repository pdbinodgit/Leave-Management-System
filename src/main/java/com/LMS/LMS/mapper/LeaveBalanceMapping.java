package com.LMS.LMS.mapper;


import com.LMS.LMS.leavebalance.dto.LeaveBalanceDto;
import com.LMS.LMS.leavebalance.model.LeaveBalance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveBalanceMapping {
    public LeaveBalanceDto entityToDto(LeaveBalance balance);

    public LeaveBalance dtoToEntity(LeaveBalanceDto dto);
}
