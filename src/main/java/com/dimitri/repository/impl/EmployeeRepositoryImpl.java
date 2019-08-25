package com.dimitri.repository.impl;

import com.dimitri.domain.Employee;
import com.dimitri.repository.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static EmployeeRepository employeeRepository = null;
    private Set<Employee>employees;

    public EmployeeRepositoryImpl(){
        this.employees = new HashSet<>();
    }

    public static EmployeeRepository getEmployeeRepository(){
        if(employeeRepository == null)employeeRepository = new EmployeeRepositoryImpl();
        return employeeRepository;
    }
    public Employee search(String id){
        for(Employee employeeSearch:this.employees){
            if(employeeSearch.getEmployeeId().equals(id))
                return employeeSearch;
        }
        return null;
    }
    @Override
    public Set<Employee> getAll() {
        return this.employees;
    }

    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee toDelete = search(employee.getEmployeeId());
        if(toDelete != null){
            employees.remove(toDelete);
            return create(employee);
        }
        return null;
    }

    @Override
    public Employee read(String s) {
        return search(s);
    }

    @Override
    public void delete(String s) {
        Employee toDelete = search(s);
        if(toDelete != null){
            employees.remove(toDelete);
        }
    }
}
