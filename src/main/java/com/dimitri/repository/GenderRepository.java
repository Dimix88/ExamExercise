package com.dimitri.repository;

import com.dimitri.domain.Gender;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {
    Set<Gender>getAll();
}
