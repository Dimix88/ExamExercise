package com.dimitri.domain;

import java.util.Objects;

public class Race implements Comparable<Race>{
    private String raceId;
    private String raceDescription;

    private Race(){}

    public Race(Builder builder){
        this.raceId = builder.raceId;
        this.raceDescription = builder.raceDescription;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getRaceDescription() {
        return raceDescription;
    }

    @Override
    public int compareTo(Race o) {
        return this.raceId.compareTo(o.raceId);
    }

    public static class Builder{
        String raceId;
        String raceDescription;

        public Builder raceId(String raceId){
            this.raceId = raceId;
            return this;
        }
        public Builder raceDescription(String raceDescription){
            this.raceDescription = raceDescription;
            return this;
        }
        public Builder copy(Race race){
            this.raceId = race.raceId;
            this.raceDescription = raceDescription;
            return this;
        }
        public Race build(){
            return new Race(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race)) return false;
        Race race = (Race) o;
        return raceId.equals(race.raceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId);
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", raceDescription='" + raceDescription + '\'' +
                '}';
    }
}
