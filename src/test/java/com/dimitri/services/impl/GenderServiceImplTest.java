package com.dimitri.services.impl;

import com.dimitri.domain.Gender;
import com.dimitri.factory.GenderFactory;
import com.dimitri.repository.GenderRepository;
import com.dimitri.repository.impl.GenderRepositoryImpl;
import com.dimitri.services.GenderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceImplTest {
    private static GenderService genderService;
    private GenderRepository genderRepository;
    private Gender gender;

    @Before
    public void setUp() throws Exception {
        this.genderRepository = GenderRepositoryImpl.getGenderRepository();
        genderService = GenderServiceImpl.getGenderService();
        gender = GenderFactory.buildGender("Male");
        genderService.create(gender);
    }

    @Test
    public void getAll() {
        Set<Gender> all = genderService.getAll();
        Assert.assertEquals(all.size(), genderService.getAll().size());
        Assert.assertSame(all.size(),genderService.getAll().size());
    }

    @Test
    public void create() {
        Gender gender1 = GenderFactory.buildGender("Male");
        genderService.create(gender1);
        String desc = "Male";
        Assert.assertEquals(gender1.getGenderDescription(),genderService.read(gender1.getGenderId()).getGenderDescription());
        Assert.assertNotNull(gender1);
        Assert.assertEquals(desc, genderService.read(gender1.getGenderId()).getGenderDescription());
        Assert.assertSame(gender1, genderService.read(gender1.getGenderId()));
    }

    @Test
    public void update() {
        String newDesc = "Female";
        Gender newGender = new Gender.Builder().copy(gender).genderDescription(newDesc).build();
        genderService.update(newGender);
        Assert.assertEquals(newGender,genderService.read(gender.getGenderId()));

    }

    @Test
    public void read() {
        Gender read = genderService.read(gender.getGenderId());
        Assert.assertEquals(read, genderService.read(read.getGenderId()));
        Assert.assertEquals(read, genderService.read(gender.getGenderId()));
    }

    @Test
    public void delete() {
        Gender deleteGender = GenderFactory.buildGender("Males");
        genderService.create(deleteGender);
        genderService.delete(deleteGender.getGenderId());
        Gender result = genderService.read(deleteGender.getGenderId());
        Assert.assertFalse(genderService.getAll().iterator().next().getGenderDescription().contains("Males"));
        Assert.assertNull(result);
    }
}