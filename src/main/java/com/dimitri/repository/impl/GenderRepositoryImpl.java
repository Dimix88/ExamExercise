package com.dimitri.repository.impl;

import com.dimitri.domain.Gender;
import com.dimitri.repository.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {
    private static GenderRepository genderRepository = null;
    private Set<Gender>genders;

    private GenderRepositoryImpl(){
        this.genders = new HashSet<>();
    }
    public static GenderRepository getGenderRepository(){
        if(genderRepository == null)genderRepository = new GenderRepositoryImpl();
        return genderRepository;
    }
    public Gender search(String id){
        for(Gender searchGender:this.genders){
            if(searchGender.getGenderId().equals(id)){
                return searchGender;
            }
        }
        return null;
    }
    @Override
    public Set<Gender> getAll() {
        return this.genders;
    }

    @Override
    public Gender create(Gender gender) {
        this.genders.add(gender);
        return gender;
    }

    @Override
    public Gender update(Gender gender) {
        Gender toDelete = search(gender.getGenderId());
        if(toDelete != null){
            this.genders.remove(toDelete);
            return create(gender);
        }
        return null;
    }

    @Override
    public Gender read(String s) {
        return search(s);
    }

    @Override
    public void delete(String s) {
        Gender toDelete = search(s);
        if(toDelete != null){
            this.genders.remove(toDelete);
        }
    }
}
