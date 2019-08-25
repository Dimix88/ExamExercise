package com.dimitri.factory;

import com.dimitri.domain.Gender;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    @Test
    public void buildGender() {
        Gender gender = GenderFactory.buildGender("Male");
        String desc = "Male";
        Assert.assertEquals(desc, gender.getGenderDescription());
        Assert.assertNotNull(gender);
    }
}