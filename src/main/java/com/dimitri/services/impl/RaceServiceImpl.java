package com.dimitri.services.impl;

import com.dimitri.domain.Race;
import com.dimitri.repository.RaceRepository;
import com.dimitri.repository.impl.RaceRepositoryImpl;
import com.dimitri.services.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService{

    private static RaceService service = null;
    private RaceRepository raceRepository;

    private RaceServiceImpl(){
        this.raceRepository = RaceRepositoryImpl.getRepository();
    }
    public static RaceService getService(){
        if(service == null) service = new RaceServiceImpl();
        return service;
    }
    @Override
    public Set<Race> getAll() {
        return raceRepository.getAll();
    }

    @Override
    public Race create(Race race) {
        return this.raceRepository.create(race);
    }

    @Override
    public Race update(Race race) {
        return this.raceRepository.update(race);
    }

    @Override
    public Race read(String s) {
        return this.raceRepository.read(s);
    }

    @Override
    public void delete(String s) {
        this.raceRepository.delete(s);
    }
}
