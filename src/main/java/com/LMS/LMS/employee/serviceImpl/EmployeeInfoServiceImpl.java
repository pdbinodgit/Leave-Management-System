package com.LMS.LMS.employee.serviceImpl;

import com.LMS.LMS.employee.dto.EmployeeInformationDto;
import com.LMS.LMS.employee.repository.EmployeeInfoRepo;
import com.LMS.LMS.employee.service.EmployeeInfoService;
import com.LMS.LMS.mapper.EmployeeInformationMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

    @Autowired
    EmployeeInfoRepo employeeInfoRepo;

    @Autowired
    EmployeeInformationMapping employeeInformationMapping;

    @Override
    public EmployeeInformationDto saveEmployeeInformation(EmployeeInformationDto dto) {
        return null;
    }

    @Override
    public List<EmployeeInformationDto> findAllEmployee() {
        return List.of();
    }

    @Override
    public EmployeeInformationDto findByEmployeeCode(String code) {
        return null;
    }
}
