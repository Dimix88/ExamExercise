package com.dimitri.repository.impl;

import com.dimitri.domain.EmployeeGender;
import com.dimitri.factory.EmployeeGenderFactory;
import com.dimitri.repository.EmployeeGenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeGenderRepositoryImplTest {
    private EmployeeGenderRepository employeeGenderRepository;
    private EmployeeGender employeeGender;
    private Set<EmployeeGender>employeeGenders;

    @Before
    public void setUp() throws Exception {
        this.employeeGenderRepository = EmployeeGenderRepositoryImpl.getEmployeeGenderRepository();
        this.employeeGenders = new HashSet<>();
        employeeGender = EmployeeGenderFactory.buildEmployeeGender("11","22");
        this.employeeGenders.add(this.employeeGenderRepository.create(employeeGender));
    }

    @Test
    public void d_getAll() {
        Set<EmployeeGender>all = this.employeeGenderRepository.getAll();
        Assert.assertEquals(all.size(),this.employeeGenderRepository.getAll().size());
        Assert.assertSame(all.size(),this.employeeGenderRepository.getAll().size());
    }

    @Test
    public void a_create() {
        EmployeeGender employeeGender1 = EmployeeGenderFactory.buildEmployeeGender("55","66");
        this.employeeGenders.add(employeeGenderRepository.create(employeeGender1));
        String id = "55";
        Assert.assertEquals(id, this.employeeGenderRepository.read(employeeGender1.getEmployeeId()).getEmployeeId());
        Assert.assertNotNull(employeeGender1);
        Assert.assertEquals(employeeGender1,this.employeeGenderRepository.read(employeeGender1.getEmployeeId()));
    }

    @Test
    public void b_update() {
        String newId = "8888";
        EmployeeGender newEmployeeGender = new EmployeeGender.Builder().copy(employeeGender).genderId(newId).build();
        this.employeeGenders.add(employeeGenderRepository.update(newEmployeeGender));
        Assert.assertEquals(newEmployeeGender, employeeGenderRepository.read(newEmployeeGender.getEmployeeId()));
        Assert.assertEquals(newEmployeeGender.getGenderId(), employeeGenderRepository.read(newEmployeeGender.getEmployeeId()).getGenderId());
    }

    @Test
    public void c_read() {
        EmployeeGender read = employeeGenderRepository.read(employeeGender.getEmployeeId());
        Assert.assertEquals(read, this.employeeGenderRepository.read(employeeGender.getEmployeeId()));
        Assert.assertEquals(read, this.employeeGenderRepository.read(read.getEmployeeId()));
    }

    @Test
    public void e_delete() {
        EmployeeGender deleteEmployeeGender = EmployeeGenderFactory.buildEmployeeGender("999","656");
        this.employeeGenders.add(employeeGenderRepository.create(deleteEmployeeGender));
        this.employeeGenders.remove(deleteEmployeeGender);
        this.employeeGenderRepository.delete(deleteEmployeeGender.getEmployeeId());
        EmployeeGender result = this.employeeGenderRepository.read(deleteEmployeeGender.getEmployeeId());
        Assert.assertFalse(this.employeeGenderRepository.getAll().iterator().next().getGenderId().contains("999"));
        Assert.assertNull(result);
    }
}