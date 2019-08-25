package com.dimitri.services;

import com.dimitri.domain.EmployeeGender;

import java.util.Set;

public interface EmployeeGenderService extends IService<EmployeeGender,String> {
    Set<EmployeeGender>getAll();
}
