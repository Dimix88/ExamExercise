package com.dimitri.services.impl;

import com.dimitri.domain.Gender;
import com.dimitri.repository.GenderRepository;
import com.dimitri.repository.impl.GenderRepositoryImpl;
import com.dimitri.services.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {
    private static GenderService genderService = null;
    private GenderRepository genderRepository;
     private GenderServiceImpl(){
         this.genderRepository = GenderRepositoryImpl.getGenderRepository();
     }
     public static GenderService getGenderService(){
         if(genderService == null) genderService = new GenderServiceImpl();
         return genderService;
     }
    @Override
    public Set<Gender> getAll() {
        return this.genderRepository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return this.genderRepository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.genderRepository.update(gender);
    }

    @Override
    public Gender read(String s) {
        return this.genderRepository.read(s);
    }

    @Override
    public void delete(String s) {
        this.genderRepository.delete(s);
    }
}
