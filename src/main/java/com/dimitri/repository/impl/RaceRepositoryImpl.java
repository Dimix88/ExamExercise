package com.dimitri.repository.impl;

import com.dimitri.domain.Race;
import com.dimitri.repository.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {
    private static RaceRepository repository = null;
    private Race race;
    private Set<Race>races;

    private RaceRepositoryImpl(){
        this.races = new HashSet<>();
    }

    public static RaceRepository getRepository(){
        if(repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }
    public Race search(String id){
        for(Race searchRace: this.races){
            if(searchRace.getRaceId().equals(id)){
                return searchRace;
            }
        }
        return null;
    }
    @Override
    public Set<Race> getAll() {
        return this.races;
    }

    @Override
    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    @Override
    public Race update(Race race) {
        Race toDelete = search(race.getRaceId());
        if(toDelete!=null){
            this.races.remove(toDelete);
            return create(race);

        }
        return null;
    }

    @Override
    public Race read(String s) {
        return search(s);
    }

    @Override
    public void delete(String s) {
        Race toDelete = search(s);
        if(toDelete!= null) {
            this.races.remove(toDelete);
        }
    }
}
