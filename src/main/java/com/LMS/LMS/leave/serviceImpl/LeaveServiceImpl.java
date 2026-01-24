package com.LMS.LMS.leave.serviceImpl;

import com.LMS.LMS.exception.LmsException;
import com.LMS.LMS.leave.dto.LeaveDto;
import com.LMS.LMS.leave.model.LeaveInformation;
import com.LMS.LMS.leave.repository.LeaveRepo;
import com.LMS.LMS.leave.service.LeaveService;
import com.LMS.LMS.mapper.LeaveMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    LeaveMapping leaveMapping;

    @Autowired
    LeaveRepo leaveRepo;

    @Override
    public LeaveDto saveLeave(LeaveDto dto) {

        Optional<LeaveInformation> leaveInformation=leaveRepo.findByLeaveTypeAndPresentStatus(dto.getLeaveType(),true);
        if (leaveInformation.isPresent()){
            throw new LmsException(dto.getLeaveType()+" already present.", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }
        LeaveInformation information= leaveMapping.dtoToEntity(dto);
        information.setPresentStatus(true);

        return leaveMapping.entityToDto(leaveRepo.save(information)) ;
    }

    @Override
    public List<LeaveDto> findAllLeave() {
        List<LeaveInformation> leaveInformations=leaveRepo.findAll();
        List<LeaveDto> dtos=new ArrayList<>();
        for (LeaveInformation information:leaveInformations){
            dtos.add(leaveMapping.entityToDto(information));
        }
        return dtos;
    }

    @Override
    public List<LeaveDto> findByStatus(boolean status) {
        List<LeaveInformation> leaveInformations=leaveRepo.findByPresentStatus(status);
        List<LeaveDto> dtos=new ArrayList<>();
        for (LeaveInformation information:leaveInformations){
            dtos.add(leaveMapping.entityToDto(information));
        }
        return dtos;
    }

    @Override
    public LeaveDto findByLeaveType(String leave) {
        Optional<LeaveInformation> leaveInformation=leaveRepo.findByLeaveTypeAndPresentStatus(leave,true);
        if (leaveInformation.isPresent()) {
            return leaveMapping.entityToDto(leaveInformation.get());
        }else {
            throw new LmsException(leave+" is not present.",HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }
    }
}
