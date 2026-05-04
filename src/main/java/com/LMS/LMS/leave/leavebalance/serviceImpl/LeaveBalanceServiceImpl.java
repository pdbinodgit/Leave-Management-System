package com.LMS.LMS.leave.leavebalance.serviceImpl;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.leavebalance.model.LeaveBalance;
import com.LMS.LMS.leave.leavebalance.repository.LeaveBalanceRepository;
import com.LMS.LMS.leave.leavebalance.service.LeaveBalanceService;
import com.LMS.LMS.leave.leaveinformation.model.LeaveInformation;
import com.LMS.LMS.leave.leaveinformation.repository.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

    @Autowired
    LeaveBalanceRepository leaveBalanceRepository;
    @Autowired
    LeaveRepo leaveRepo;

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
}
