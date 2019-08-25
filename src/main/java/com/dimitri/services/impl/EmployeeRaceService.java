package com.dimitri.services.impl;

import com.dimitri.domain.Employee;
import com.dimitri.domain.Race;
import com.dimitri.factory.EmployeeFactory;
import com.dimitri.factory.RaceFactory;
import com.dimitri.services.EmployeeService;
import com.dimitri.services.RaceService;

public class EmployeeRaceService {
    private EmployeeService employeeService = EmployeeServiceImpl.getEmployeeService();
    private RaceService raceService = RaceServiceImpl.getService();


    public Employee makeEmployee(String fName, String lName, String description){
        Employee employee = EmployeeFactory.buildEmployee(fName,lName);
        this.employeeService.create(employee);
        Race race = RaceFactory.buildRace(description);
        this.raceService.create(race);
        return employee;
    }
}
