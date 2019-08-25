package com.dimitri.repository.impl;

import com.dimitri.domain.Gender;
import com.dimitri.factory.GenderFactory;
import com.dimitri.repository.GenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {
    private static GenderRepository genderRepository;
    private Gender gender;
    private Set<Gender>genders;
    @Before
    public void setUp() throws Exception {
        this.genderRepository = GenderRepositoryImpl.getGenderRepository();
        this.genders = new HashSet<>();
        gender = GenderFactory.buildGender("Male");
        this.genders.add(genderRepository.create(gender));
    }

    @Test
    public void d_getAll() {
        Set<Gender> all = this.genderRepository.getAll();
        Assert.assertEquals(all.size(), this.genderRepository.getAll().size());
        Assert.assertSame(all.size(), this.genderRepository.getAll().size());
    }

    @Test
    public void a_create() {
        Gender gender1 = GenderFactory.buildGender("Female");
        this.genders.add(genderRepository.create(gender1));
        String desc = "Female";
        Assert.assertNotNull(gender1);
        Assert.assertEquals(desc, genderRepository.read(gender1.getGenderId()).getGenderDescription());
    }

    @Test
    public void b_update() {
        String desc = "Female";
        Gender newGender = new Gender.Builder().copy(gender).genderDescription(desc).build();
        this.genders.add(this.genderRepository.update(newGender));
        Assert.assertEquals(desc, genderRepository.read(newGender.getGenderId()).getGenderDescription());
        Assert.assertEquals(newGender, genderRepository.read(newGender.getGenderId()));
    }

    @Test
    public void c_read() {
        Gender read = this.genderRepository.read(gender.getGenderId());
        Assert.assertEquals(read, this.genderRepository.read(gender.getGenderId()));
        Assert.assertEquals(read, this.genderRepository.read(read.getGenderId()));
    }

    @Test
    public void e_delete() {
        Gender deleteGender = GenderFactory.buildGender("Males");
        this.genders.add(this.genderRepository.create(deleteGender));
        this.genders.remove(deleteGender);
        this.genderRepository.delete(deleteGender.getGenderId());
        Gender result = this.genderRepository.read(deleteGender.getGenderId());
        Assert.assertFalse(this.genderRepository.getAll().iterator().next().getGenderDescription().contains("Males"));
        Assert.assertNull(result);
    }
}