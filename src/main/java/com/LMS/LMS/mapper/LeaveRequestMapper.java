package com.LMS.LMS.mapper;

import com.LMS.LMS.leaverequest.dto.LeaveRequestDto;
import com.LMS.LMS.leaverequest.model.LeaveRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveRequestMapper {

    public LeaveRequestDto entityToDto(LeaveRequest leave);

    public LeaveRequest dtoToEntity(LeaveRequestDto dto);
}
