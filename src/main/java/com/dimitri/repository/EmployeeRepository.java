package com.dimitri.repository;

import com.dimitri.domain.Employee;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {
    Set<Employee>getAll();
}
