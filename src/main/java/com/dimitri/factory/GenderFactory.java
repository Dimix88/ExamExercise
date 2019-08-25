package com.dimitri.factory;

import com.dimitri.domain.Gender;
import com.dimitri.util.Misc;

public class GenderFactory {
    public static Gender buildGender(String descript){
        return new Gender.Builder()
                .genderId(Misc.generateId())
                .genderDescription(descript)
                .build();
    }
}
