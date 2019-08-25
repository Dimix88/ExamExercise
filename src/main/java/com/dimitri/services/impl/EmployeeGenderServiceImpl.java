package com.dimitri.services.impl;

import com.dimitri.domain.EmployeeGender;
import com.dimitri.repository.EmployeeGenderRepository;
import com.dimitri.repository.impl.EmployeeGenderRepositoryImpl;
import com.dimitri.services.EmployeeGenderService;

import java.util.Set;

public class EmployeeGenderServiceImpl implements EmployeeGenderService {
    private static EmployeeGenderService service = null;
    private EmployeeGenderRepository repository;

    private EmployeeGenderServiceImpl(){
        this.repository = EmployeeGenderRepositoryImpl.getEmployeeGenderRepository();
    }
    public static EmployeeGenderService getEmployeeGenderService(){
        if(service == null) service = new EmployeeGenderServiceImpl();
        return service;
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return this.repository.getAll();
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        return this.repository.create(employeeGender);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        return this.repository.update(employeeGender);
    }

    @Override
    public EmployeeGender read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }
}
