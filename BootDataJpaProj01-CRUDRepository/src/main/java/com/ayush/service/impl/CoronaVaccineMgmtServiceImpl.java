package com.ayush.service.impl;

import com.ayush.entity.CoronaVaccine;
import com.ayush.repo.CoronaVaccineRepo;
import com.ayush.service.CoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements CoronaVaccineMgmtService {

    private final CoronaVaccineRepo vaccineRepo;

    public CoronaVaccineMgmtServiceImpl(@Autowired CoronaVaccineRepo vaccineRepo){
        this.vaccineRepo=vaccineRepo;
    }

    @Override
    public String registerVaccine(CoronaVaccine vaccine) {
        CoronaVaccine registeredVaccine = null;
        if(vaccine != null)
            registeredVaccine = vaccineRepo.save(vaccine);
        return registeredVaccine != null ? "Vaccine registered/updated with "+registeredVaccine.getRegNo() : "Vaccine registration/update failed";
    }

}
