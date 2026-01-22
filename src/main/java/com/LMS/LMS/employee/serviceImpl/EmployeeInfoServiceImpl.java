package com.LMS.LMS.employee.serviceImpl;

import com.LMS.LMS.employee.dto.EmployeeInformationDto;
import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.employee.repository.EmployeeInfoRepo;
import com.LMS.LMS.employee.service.EmployeeInfoService;
import com.LMS.LMS.exception.LmsException;
import com.LMS.LMS.mapper.EmployeeInformationMapping;
import com.LMS.LMS.util.AutoGenerateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

    @Autowired
    EmployeeInfoRepo employeeInfoRepo;

    @Autowired
    EmployeeInformationMapping employeeInformationMapping;

    @Autowired
    AutoGenerateCode autoGenerateCode;

    @Override
    public EmployeeInformationDto saveEmployeeInformation(EmployeeInformationDto dto) {
        String employeeCode=autoGenerateCode.generateEmployeeCode();
        if (employeeCode.isEmpty()){
            throw new LmsException("Employee code error", HttpStatus.INTERNAL_SERVER_ERROR,500);
        }
        EmployeeInformation information=employeeInformationMapping.dtoToEntity(dto);
        information.setEmployeeCode(employeeCode);
        information.setCreatedAt(LocalDateTime.now());
        return employeeInformationMapping.entityToDto(employeeInfoRepo.save(information));

    }

    @Override
    public List<EmployeeInformationDto> findAllEmployee() {
        List<EmployeeInformation> employeeInformationList=employeeInfoRepo.findAll();
        List<EmployeeInformationDto> dtoList=new ArrayList<>();
        for (EmployeeInformation information:employeeInformationList){
            dtoList.add(employeeInformationMapping.entityToDto(information));
        }

        return dtoList;
    }

    @Override
    public EmployeeInformationDto findByEmployeeCode(String code) {
        Optional<EmployeeInformation> optionalEmployeeInformation=employeeInfoRepo.findByEmployeeCode(code);
        if (optionalEmployeeInformation.isPresent()){
            return employeeInformationMapping.entityToDto(optionalEmployeeInformation.get());
        }else {
            return new EmployeeInformationDto();
        }
    }
}
