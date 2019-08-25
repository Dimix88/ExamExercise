package com.dimitri.services.impl;

import com.dimitri.domain.Employee;
import com.dimitri.repository.EmployeeRepository;
import com.dimitri.repository.impl.EmployeeRepositoryImpl;
import com.dimitri.services.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeService employeeService = null;
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl(){
        this.employeeRepository = EmployeeRepositoryImpl.getEmployeeRepository();
    }

    public static EmployeeService getEmployeeService(){
        if(employeeService == null) employeeService = new EmployeeServiceImpl();
        return employeeService;
    }
    @Override
    public Set<Employee> getAll() {
        return this.employeeRepository.getAll();
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.update(employee);
    }

    @Override
    public Employee read(String s) {
        return this.employeeRepository.read(s);
    }

    @Override
    public void delete(String s) {
        this.employeeRepository.delete(s);
    }
}
