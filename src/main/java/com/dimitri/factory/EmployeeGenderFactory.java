package com.dimitri.factory;

import com.dimitri.domain.EmployeeGender;

public class EmployeeGenderFactory {
    public static EmployeeGender buildEmployeeGender(String empId,String genId){
        return new EmployeeGender.Builder()
                .employeeId(empId)
                .genderId(genId)
                .build();
    }
}
