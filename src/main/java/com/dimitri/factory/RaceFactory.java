package com.dimitri.factory;

import com.dimitri.domain.Race;
import com.dimitri.util.Misc;

public class RaceFactory {
    public static Race buildRace(String description){
        return new Race.Builder()
                .raceId(Misc.generateId())
                .raceDescription(description)
                .build();
    }
}
