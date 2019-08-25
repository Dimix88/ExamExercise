package com.dimitri.repository;

import com.dimitri.domain.Race;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {
    Set<Race>getAll();
}
