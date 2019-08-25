package com.dimitri.repository.impl;

import com.dimitri.domain.EmployeeGender;
import com.dimitri.repository.EmployeeGenderRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImpl implements EmployeeGenderRepository {
    private static EmployeeGenderRepository employeeGenderRepository=null;
    private EmployeeGender employeeGender;
    private Set<EmployeeGender>employeeGenders;

    private EmployeeGenderRepositoryImpl(){
        this.employeeGenders = new HashSet<>();
    }
    public static EmployeeGenderRepository getEmployeeGenderRepository(){
        if(employeeGenderRepository == null) employeeGenderRepository = new EmployeeGenderRepositoryImpl();
        return employeeGenderRepository;
    }
    public EmployeeGender search(String id){
        for(EmployeeGender searchEmployeeGender:this.employeeGenders){
            if(searchEmployeeGender.getEmployeeId().equals(id)){
                return searchEmployeeGender;
            }
        }
        return null;
    }
    @Override
    public Set<EmployeeGender> getAll() {
        return this.employeeGenders;
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        this.employeeGenders.add(employeeGender);
        return employeeGender;
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        EmployeeGender toDelete = search(employeeGender.getEmployeeId());
        if(toDelete!= null){
            this.employeeGenders.remove(toDelete);
            return create(employeeGender);
        }
        return null;
    }

    @Override
    public EmployeeGender read(String s) {
        return search(s);
    }

    @Override
    public void delete(String s) {
        EmployeeGender toDelete = search(s);
        if(toDelete!= null){
            this.employeeGenders.remove(toDelete);
        }

    }
}
