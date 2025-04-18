package com.ayush.runners;

import com.ayush.entity.CoronaVaccine;
import com.ayush.repo.CoronaVaccineRepo;
import com.ayush.service.CoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

    @Autowired
    private CoronaVaccineMgmtService service;

    @Override
    public void run(String... args) throws Exception {
        CoronaVaccine vaccine = new CoronaVaccine("covishield", "Serum", "India", 500.90, 1);
        String result = service.registerVaccine(vaccine);
        System.out.println(result);
    }
}
