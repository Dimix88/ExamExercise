package com.dimitri.factory;

import com.dimitri.domain.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void buildRace() {
        Race race = RaceFactory.buildRace("Coloured");
        String desc = "Coloured";
        Assert.assertNotNull(race);
        Assert.assertEquals(desc, race.getRaceDescription());
    }
}