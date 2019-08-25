package com.dimitri.repository.impl;

import com.dimitri.domain.Employee;
import com.dimitri.factory.EmployeeFactory;
import com.dimitri.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {
    private EmployeeRepository employeeRepository;
    private Employee employee;
    private Set<Employee>employees;

    @Before
    public void setUp() throws Exception {
        this.employeeRepository = new EmployeeRepositoryImpl().getEmployeeRepository();
        this.employees = new HashSet<>();
        employee = EmployeeFactory.buildEmployee("Dimitri","Ferus");
        this.employees.add(this.employeeRepository.create(employee));
    }

    @Test
    public void d_getAll() {
        Set<Employee>all = this.employeeRepository.getAll();
        Assert.assertEquals(all.size(),employeeRepository.getAll().size());
        Assert.assertSame(all.size(),employeeRepository.getAll().size());
    }

    @Test
    public void a_create() {
        Employee employee1 = EmployeeFactory.buildEmployee("Mark","Jones");
        employees.add(employeeRepository.create(employee1));
        String name = "Mark";
        Assert.assertEquals(name, employee1.getEmployeeFirstName());
        Assert.assertEquals(employee1, employeeRepository.read(employee1.getEmployeeId()));
        Assert.assertNotNull(employee1);
    }

    @Test
    public void b_update() {
        String newName = "Ben";
        Employee newEmployee = new Employee.Builder().copy(employee).employeeFirstName(newName).build();
        employees.add(this.employeeRepository.update(newEmployee));
        Assert.assertEquals(newEmployee, this.employeeRepository.read(newEmployee.getEmployeeId()));

    }

    @Test
    public void c_read() {
        Employee read = this.employeeRepository.read(employee.getEmployeeId());
        Assert.assertEquals(read, this.employeeRepository.read(read.getEmployeeId()));
        Assert.assertEquals(read.getEmployeeId(),this.employeeRepository.read(read.getEmployeeId()).getEmployeeId());
    }

    @Test
    public void e_delete() {
        Employee deleteEmployee = EmployeeFactory.buildEmployee("Jack","Middleton");
        employees.add(this.employeeRepository.create(deleteEmployee));
        this.employees.remove(deleteEmployee);
        this.employeeRepository.delete(deleteEmployee.getEmployeeId());
        Employee result = this.employeeRepository.read(deleteEmployee.getEmployeeId());
        Assert.assertFalse(this.employeeRepository.getAll().iterator().next().getEmployeeFirstName().contains("Jack"));
        Assert.assertNull(result);

    }
}