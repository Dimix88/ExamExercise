package com.dimitri.domain;

import java.util.Objects;

public class Gender implements Comparable<Gender.Builder> {
    private String genderId;
    private String genderDescription;

    private Gender(){}

    public Gender(Builder builder){
        this.genderId = builder.genderId;
        this.genderDescription = builder.genderDescription;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGenderDescription() {
        return genderDescription;
    }
    public static class Builder{
        String genderId;
        String genderDescription;

        public Builder genderId(String genderId){
            this.genderId = genderId;
            return this;
        }
        public Builder genderDescription(String genderDescription){
            this.genderDescription = genderDescription;
            return this;
        }
        public Builder copy(Gender gender){
            this.genderId = gender.genderId;
            this.genderDescription = gender.genderDescription;
            return this;
        }
        public Gender build(){
            return new Gender(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender)) return false;
        Gender gender = (Gender) o;
        return genderId.equals(gender.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId);
    }

    @Override
    public int compareTo(Builder o) {
        return this.genderId.compareTo(o.genderId);
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", genderDescription='" + genderDescription + '\'' +
                '}';
    }
}
