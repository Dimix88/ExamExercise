package com.dimitri.factory;

import com.dimitri.domain.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void buildEmployee() {
        Employee employee = EmployeeFactory.buildEmployee("Dimitri","Ferus");
        String name= employee.getEmployeeFirstName();
        Assert.assertEquals(name, employee.getEmployeeFirstName());
        Assert.assertNotNull(employee);
    }
}