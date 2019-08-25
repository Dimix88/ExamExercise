package com.dimitri.services;

import com.dimitri.domain.Employee;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee>getAll();
}
