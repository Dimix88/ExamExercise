package com.dimitri.services;

import com.dimitri.domain.Gender;
import com.dimitri.services.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, String> {
    Set<Gender>getAll();
}
