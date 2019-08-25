package com.dimitri.repository;

import com.dimitri.domain.EmployeeGender;

import java.util.Set;

public interface EmployeeGenderRepository extends IRepository<EmployeeGender,String> {
    Set<EmployeeGender>getAll();
}
