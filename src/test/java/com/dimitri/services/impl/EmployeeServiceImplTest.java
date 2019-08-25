 package com.dimitri.services.impl;

import com.dimitri.domain.Employee;
import com.dimitri.factory.EmployeeFactory;
import com.dimitri.services.EmployeeService;
import com.dimitri.services.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class EmployeeServiceImplTest {
    private EmployeeService employeeService;
    private Employee employee;
    @Before
    public void setUp() throws Exception {
        this.employeeService = EmployeeServiceImpl.getEmployeeService();
        employee = EmployeeFactory.buildEmployee("Dimitri","Ferus");
        this.employeeService.create(employee);
    }

    @Test
    public void getAll() {
        Set<Employee>all = employeeService.getAll();
        Assert.assertEquals(all.size(), employeeService.getAll().size());
        Assert.assertSame(all.size(),employeeService.getAll().size());
    }

    @Test
    public void create() {
        Employee employee1 = EmployeeFactory.buildEmployee("Dineashia","Ferus");
        this.employeeService.create(employee1);
        Assert.assertEquals(employee1, employeeService.read(employee1.getEmployeeId()));
    }

    @Test
    public void update() {
        String newName = "Mike";
        Employee newEmployee = new Employee.Builder().copy(employee).employeeFirstName(newName).build();
        this.employeeService.update(newEmployee);
        Assert.assertEquals(newEmployee, this.employeeService.read(newEmployee.getEmployeeId()));
    }

    @Test
    public void read() {
        Employee read = this.employeeService.read(employee.getEmployeeId());
        Assert.assertEquals(read, this.employeeService.read(read.getEmployeeId()));
    }

    @Test
    public void delete() {
        Employee deleteEmployee = EmployeeFactory.buildEmployee("Mike","Larry");
        employeeService.create(deleteEmployee);
        employeeService.delete(deleteEmployee.getEmployeeId());
        Employee result = employeeService.read(deleteEmployee.getEmployeeId());
        Assert.assertFalse(this.employeeService.getAll().iterator().next().getEmployeeFirstName().contains("Mike"));
        Assert.assertNull(result);
    }
}