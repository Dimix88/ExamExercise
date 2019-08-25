package com.dimitri.repository.impl;

import com.dimitri.domain.Race;
import com.dimitri.factory.RaceFactory;
import com.dimitri.repository.RaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRepositoryImplTest {
    private static RaceRepository raceRepository;
    private Race race;
    private Set<Race>races;

    @Before
    public void setUp() throws Exception {
        this.raceRepository = RaceRepositoryImpl.getRepository();
        this.races = new HashSet<>();
        race = RaceFactory.buildRace("Coloured");
        this.races.add(raceRepository.create(race));
    }
    @Test
    public void d_getAll() {
        Set<Race>all = raceRepository.getAll();
        Assert.assertEquals(all.size(),this.raceRepository.getAll().size());
        Assert.assertSame(all.size(),this.raceRepository.getAll().size());
    }

    @Test
    public void a_create() {
        Race race1 = RaceFactory.buildRace("Indian");
        this.races.add(raceRepository.create(race1));
        String desc = "Indian";
        Assert.assertNotNull(race1);
        Assert.assertEquals(desc,raceRepository.read(race1.getRaceId()).getRaceDescription());
        Assert.assertEquals(race1,raceRepository.read(race1.getRaceId()));
    }

    @Test
    public void b_update() {
        String descrip = "Asian";
        Race updateRace = new Race.Builder().copy(race).raceDescription(descrip).build();
        this.races.add(raceRepository.update(updateRace));
        Assert.assertEquals(updateRace,raceRepository.read(updateRace.getRaceId()));
    }

    @Test
    public void c_read() {
        Race read = raceRepository.read(race.getRaceId());
        Assert.assertEquals(read,raceRepository.read(race.getRaceId()));
    }

    @Test
    public void e_delete() {
        Race deleteRace = RaceFactory.buildRace("Asian");
        this.races.add(raceRepository.create(deleteRace));
        this.races.remove(deleteRace);
        this.raceRepository.delete(deleteRace.getRaceId());
        Race result = raceRepository.read(deleteRace.getRaceId());
        Assert.assertFalse(this.raceRepository.getAll().iterator().next().getRaceDescription().contains("Asian"));
        Assert.assertNull(result);
    }


}