package com.LMS.LMS.leave.leavebalance.serviceImpl;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.leavebalance.dto.LeaveBalanceDto;
import com.LMS.LMS.leave.leavebalance.model.LeaveBalance;
import com.LMS.LMS.leave.leavebalance.repository.LeaveBalanceRepository;
import com.LMS.LMS.leave.leavebalance.service.LeaveBalanceService;
import com.LMS.LMS.leave.leaveinformation.model.LeaveInformation;
import com.LMS.LMS.leave.leaveinformation.repository.LeaveRepo;
import com.LMS.LMS.mapper.LeaveBalanceMapping;
import com.LMS.LMS.util.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

    @Autowired
    LeaveBalanceRepository leaveBalanceRepository;
    @Autowired
    LeaveRepo leaveRepo;

    @Autowired
    UserUtility userUtility;
    @Autowired
    LeaveBalanceMapping leaveBalanceMapping;

    @Override
    public void save(EmployeeInformation employeeInformation) {

        //condition I: Leave for this is present or not

        List<LeaveInformation> leaveInformationList=leaveRepo.findByPresentStatus(true);
        for (LeaveInformation information:leaveInformationList){
            if (!information.getLeaveType().equals("Paternity Leave") && !employeeInformation.getGender().equals("Male") ||
            !information.getLeaveType().equals("Maternity Leave") && !employeeInformation.getGender().equals("Female")) {

                Optional<LeaveBalance> optionalLeaveBalance = leaveBalanceRepository
                        .findByEmployee_IdAndPresentStatusAndYearAndLeaveType_Id(employeeInformation.getId(),
                                true, String.valueOf(LocalDate.now().getYear()),
                                information.getId());
                if (!optionalLeaveBalance.isPresent()) {
                    LeaveBalance leaveBalance = new LeaveBalance();
                    leaveBalance.setLeaveType(information);
                    leaveBalance.setTotalLeave(information.getTotalLeave());
                    leaveBalance.setRemaining(information.getTotalLeave());
                    leaveBalance.setYear(String.valueOf(LocalDate.now().getYear()));
                    leaveBalance.setEmployee(employeeInformation);
                    leaveBalance.setLeaveType(information);
                    leaveBalance.setPresentStatus(true);
                    leaveBalanceRepository.save(leaveBalance);
                }
            }
        }
    }

    @Override
    public void updateLeaveBalance(long leaveId, long employeeId, long totalLeave) {

        Optional<LeaveBalance> leaveBalance=leaveBalanceRepository.findByEmployee_IdAndLeaveType_IdAndPresentStatus(employeeId,leaveId,true);
        if (leaveBalance.isPresent()){
            if (leaveBalance.get().getRemaining()>=totalLeave){
                leaveBalance.get().setRemaining(leaveBalance.get().getRemaining()-totalLeave);
                leaveBalanceRepository.save(leaveBalance.get());
            }
        }
    }

    @Override
    public List<LeaveBalanceDto> findMyLeaveBalance() {

        List<LeaveBalance> myleave = leaveBalanceRepository
                .findByEmployee_IdAndPresentStatusAndYear(userUtility.getUserId(),
                        true, String.valueOf(LocalDate.now().getYear()));

        List<LeaveBalanceDto> dtos=new ArrayList<>();
        if (!myleave.isEmpty()) {
            for (LeaveBalance leaveBalance:myleave){
             dtos.add(leaveBalanceMapping.entityToDto(leaveBalance));
            }
            return dtos;

        }else {
            return dtos;
        }

    }


}
