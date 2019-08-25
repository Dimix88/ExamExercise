package com.dimitri.services.impl;

import com.dimitri.domain.Employee;
import com.dimitri.services.EmployeeService;
import com.dimitri.services.RaceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceServiceTest {
    private static EmployeeRaceService employeeRaceService = new EmployeeRaceService();
    private EmployeeService employeeService = EmployeeServiceImpl.getEmployeeService();
    private RaceService raceService = RaceServiceImpl.getService();
    Employee employee;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void makeEmployee() {
        employee = employeeRaceService.makeEmployee("Dimitri","Ferus","Coloured");
        Assert.assertEquals("Dimitri",employee.getEmployeeFirstName());
        Assert.assertEquals("Ferus", employee.getEmployeeLastName());
        Assert.assertNotNull(employee);
        System.out.println(employee.getEmployeeFirstName());
    }
}