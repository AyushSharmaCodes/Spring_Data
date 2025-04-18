package com.ayush.runners;

import com.ayush.entity.CoronaVaccine;
import com.ayush.service.CoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

    @Autowired
    private CoronaVaccineMgmtService service;

    //run only one run method

    //bulk/ batch inseriton
    @Override
    public void run(String... args) throws Exception {
        List<CoronaVaccine> coronaVaccines = List.of(new CoronaVaccine("sputnik", "russie", "Russia", 489.4, 2),
                new CoronaVaccine("pyzer", "pyzer", "USA", 478.4, 3),
                new CoronaVaccine("moderena", "moderena", "USA", 974.4, 1));
        Iterable<CoronaVaccine> coronaVaccines1 = service.registerBatch(coronaVaccines);
        for (CoronaVaccine vaccine : coronaVaccines1) {
            System.out.println(vaccine.getRegNo());
        }
    }

    //single record insertion
    /*@Override
    public void run(String... args) throws Exception {
        CoronaVaccine vaccine = new CoronaVaccine("covishield", "Serum", "India", 500.90, 1);
        String result = service.registerVaccine(vaccine);
        System.out.println(result);
    }*/
}
