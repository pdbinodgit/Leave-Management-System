package com.LMS.LMS.leave.leaverequest.serviceImpl;

import com.LMS.LMS.exception.LmsException;
import com.LMS.LMS.leave.leavebalance.model.LeaveBalance;
import com.LMS.LMS.leave.leavebalance.repository.LeaveBalanceRepository;
import com.LMS.LMS.leave.leaverequest.dto.LeaveRequestDto;
import com.LMS.LMS.leave.leaverequest.model.LeaveRequest;
import com.LMS.LMS.leave.leaverequest.repository.LeaveRequestRepository;
import com.LMS.LMS.leave.leaverequest.service.LeaveRequestService;
import com.LMS.LMS.mapper.LeaveRequestMapper;
import com.LMS.LMS.role.UserRole;
import com.LMS.LMS.status.LeaveStatus;
import com.LMS.LMS.userinformation.model.UserInfo;
import com.LMS.LMS.userinformation.repository.UserInfoRepository;
import com.LMS.LMS.util.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    LeaveRequestRepository leaveRequestRepository;

    @Autowired
    LeaveBalanceRepository leaveBalanceRepository;
    @Autowired
    LeaveRequestMapper leaveRequestMapper;
    @Autowired
    UserUtility userUtility;
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public LeaveRequestDto saveLeave(LeaveRequestDto leaveRequestDto) {
        long days;


        boolean leaveStatus=  leaveRequestRepository
                .existsByEmployeeIdAndPresentStatusAndStartDateLessThanEqualAndEndDateGreaterThanEqual(leaveRequestDto.getEmployee().getId(),
                true,
                leaveRequestDto.getStartDate(),
                leaveRequestDto.getEndDate());
/*
        check if leave already exist or not
        -> if leave exist = Bad request
        ->if not = next step
*/
        if (leaveStatus){
            throw new LmsException("Leave already present", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }

        days= ChronoUnit.DAYS.between(leaveRequestDto.getStartDate(),leaveRequestDto.getEndDate())+1;
        /*
        * check if leave sufficient or not
        * */

        Optional<LeaveBalance> balance=leaveBalanceRepository.findByEmployee_IdAndLeaveType_IdAndPresentStatus(leaveRequestDto.getEmployee().getId(),leaveRequestDto.getLeaveInformation().getId(),true);

        if (balance.get().getRemaining()<=days){
            throw new LmsException("You don't have sufficient leave.", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }

        LeaveRequest request= leaveRequestMapper.dtoToEntity(leaveRequestDto);
        request.setPresentStatus(true);
        request.setLeaveStatus(LeaveStatus.PENDING);
        request.setTotalTakenDays(days);
        LeaveRequest requestResponse= leaveRequestRepository.save(request);
        return leaveRequestMapper.entityToDto(requestResponse);
    }

    @Override
    public List<LeaveRequestDto> findAllLeaveRequest() {
        List<LeaveRequest> list=leaveRequestRepository.findAll();
        List<LeaveRequestDto> dtoList=new ArrayList<>();
        for (LeaveRequest request:list){
            dtoList.add(leaveRequestMapper.entityToDto(request));
        }
        return dtoList;
    }

    @Override
    public List<LeaveRequestDto> findAllByStatus(LeaveStatus status) {
        List<LeaveRequestDto> listDtos=new ArrayList<>();
        List<LeaveRequest> list=leaveRequestRepository.findAllLeaveRequestByLeaveStatus(status);
        for (LeaveRequest request:list){
            listDtos.add(leaveRequestMapper.entityToDto(request));
        }
        return listDtos;
    }

    @Override
    public List<LeaveRequestDto> myAllLeave() {
        List<LeaveRequest> leaveRequestList=leaveRequestRepository.findAllLeaveRequestByEmployee_Id(userUtility.getUserId());
        List<LeaveRequestDto> dtoList=new ArrayList<>();
        for (LeaveRequest request:leaveRequestList){
           dtoList.add(leaveRequestMapper.entityToDto(request));
        }
        return dtoList;
    }

    @Override
    public List<LeaveRequestDto> leaveForAuthentication() {
        Optional<UserInfo> userInfo = userInfoRepository.findById(userUtility.getUserId());
        if (userInfo.isPresent()) {
            if (userInfo.get().getUserRole().equals(UserRole.HR)) {
                return findAllByStatus(LeaveStatus.PENDING);
            }
        }
            return new ArrayList<>();

    }


}
