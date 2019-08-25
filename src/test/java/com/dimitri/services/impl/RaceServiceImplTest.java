package com.dimitri.services.impl;

import com.dimitri.domain.Race;
import com.dimitri.factory.RaceFactory;
import com.dimitri.repository.RaceRepository;
import com.dimitri.services.RaceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceServiceImplTest {
    public static RaceService raceService;
    private Race race;
    @Before
    public void setUp() throws Exception {
        this.raceService = RaceServiceImpl.getService();
        race = RaceFactory.buildRace("Coloured");
        this.raceService.create(race);
    }

    @Test
    public void d_getAll() {
        Set<Race> all = this.raceService.getAll();
        Assert.assertEquals(all.size(),this.raceService.getAll().size());
        Assert.assertSame(all.size(),this.raceService.getAll().size());
    }

    @Test
    public void a_create() {
        Race race1 = RaceFactory.buildRace("Indian");
        String desc = race1.getRaceDescription();
        this.raceService.create(race1);
        Assert.assertEquals(race1, this.raceService.read(race1.getRaceId()));
        Assert.assertNotNull(race1);
        Assert.assertEquals(desc,this.raceService.read(race1.getRaceId()).getRaceDescription());
    }

    @Test
    public void b_update() {
        String newDesc = "Indian";
        Race newRace = new Race.Builder().copy(race).raceDescription(newDesc).build();
        this.raceService.update(newRace);
        Assert.assertEquals(newRace, this.raceService.read(newRace.getRaceId()));
    }

    @Test
    public void c_read() {
        Race read = this.raceService.read(race.getRaceId());
        Assert.assertEquals(read, this.raceService.read(race.getRaceId()));
    }

    @Test
    public void e_delete() {
        Race deleteRace = RaceFactory.buildRace("Asian");
        this.raceService.create(deleteRace);
        this.raceService.delete(deleteRace.getRaceId());
        Race result = this.raceService.read(deleteRace.getRaceId());
        Assert.assertFalse(this.raceService.getAll().iterator().next().getRaceDescription().contains("Asian"));
        Assert.assertNull(result);
    }
}