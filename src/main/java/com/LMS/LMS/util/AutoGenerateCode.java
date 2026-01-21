package com.LMS.LMS.util;


import com.LMS.LMS.employee.repository.EmployeeInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class AutoGenerateCode {

    @Autowired
    EmployeeInfoRepo employeeInfoRepo;

    private final Random random=new Random();

    public String generateEmployeeCode(){
        try {
            int code=100+random.nextInt(900);
            String finalCode="COMPANY_EMP_"+code;
            if (employeeInfoRepo.existsByEmployeeCode(finalCode)){
                return "ERROR";
            }else {
                return finalCode;
            }
        }catch (Exception e){
            throw new RuntimeException("Problem..");
        }

    }

}
