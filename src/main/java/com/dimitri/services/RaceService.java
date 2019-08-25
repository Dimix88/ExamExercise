package com.dimitri.services;

import com.dimitri.domain.Race;

import java.util.Set;

public interface RaceService extends IService<Race, String> {
    Set<Race>getAll();
}
