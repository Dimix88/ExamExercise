package com.dimitri.factory;

import com.dimitri.domain.EmployeeGender;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeGenderFactoryTest {

    @Test
    public void buildEmployeeGender() {
        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender("11","22");
        String empId = "11";
        Assert.assertNotNull(employeeGender);
        Assert.assertEquals(empId,employeeGender.getEmployeeId());
    }
}