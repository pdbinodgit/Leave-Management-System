package com.LMS.LMS.mapper;

import com.LMS.LMS.leave.dto.LeaveDto;
import com.LMS.LMS.leave.model.LeaveInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveMapping {

    public LeaveDto entityToDto(LeaveInformation leave);

    public LeaveInformation dtoToEntity(LeaveDto dto);
}
