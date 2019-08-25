package com.dimitri.services.impl;

import com.dimitri.domain.Employee;
import com.dimitri.domain.EmployeeGender;
import com.dimitri.factory.EmployeeGenderFactory;
import com.dimitri.repository.EmployeeGenderRepository;
import com.dimitri.repository.impl.EmployeeGenderRepositoryImpl;
import com.dimitri.services.EmployeeGenderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeGenderServiceImplTest {
    private EmployeeGenderService employeeGenderService;
    private EmployeeGenderRepository repository;
    private EmployeeGender employeeGender;

    @Before
    public void setUp() throws Exception {
        this.employeeGenderService = EmployeeGenderServiceImpl.getEmployeeGenderService();
        this.repository = EmployeeGenderRepositoryImpl.getEmployeeGenderRepository();
        employeeGender = EmployeeGenderFactory.buildEmployeeGender("77","88");
        employeeGenderService.create(employeeGender);
    }

    @Test
    public void d_getAll() {
        Set<EmployeeGender>all = employeeGenderService.getAll();
        Assert.assertEquals(all.size(),employeeGenderService.getAll().size());
        Assert.assertSame(all.size(), employeeGenderService.getAll().size());
    }

    @Test
    public void a_create() {
        EmployeeGender employeeGender1 = EmployeeGenderFactory.buildEmployeeGender("11","22");
        this.employeeGenderService.create(employeeGender1);
        String empId = "22";
        Assert.assertEquals(empId, employeeGenderService.read(employeeGender1.getEmployeeId()).getGenderId());
        Assert.assertNotNull(employeeGender1);
        Assert.assertEquals(employeeGender1,this.employeeGenderService.read(employeeGender1.getEmployeeId()));
    }

    @Test
    public void b_update() {
        String newGenderId = "53535";
        EmployeeGender newGender = new EmployeeGender.Builder().copy(employeeGender).genderId(newGenderId).build();
        this.employeeGenderService.update(newGender);
        Assert.assertEquals(newGender, this.employeeGenderService.read(newGender.getEmployeeId()));
        Assert.assertEquals(newGenderId, this.employeeGenderService.read(newGender.getEmployeeId()).getGenderId());
    }

    @Test
    public void c_read() {
        EmployeeGender read = this.employeeGenderService.read(employeeGender.getEmployeeId());
        Assert.assertEquals(read, this.employeeGenderService.read(read.getEmployeeId()));
        Assert.assertEquals(read, this.employeeGenderService.read(employeeGender.getEmployeeId()));
    }

    @Test
    public void e_delete() {
        EmployeeGender deleteEmployeeGender = EmployeeGenderFactory.buildEmployeeGender("555","1118");
        this.employeeGenderService.create(deleteEmployeeGender);
        this.employeeGenderService.delete(deleteEmployeeGender.getEmployeeId());
        EmployeeGender result = this.employeeGenderService.read(deleteEmployeeGender.getEmployeeId());
        Assert.assertFalse(this.employeeGenderService.getAll().iterator().next().getGenderId().contains("555"));
        Assert.assertNull(result);
    }
}