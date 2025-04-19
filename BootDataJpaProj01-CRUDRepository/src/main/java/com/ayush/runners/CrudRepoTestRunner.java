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

    //delete methods of JPA repository
    /*@Override
    public void run(String... args) throws Exception {
        //delete all the vaccines by provided ids
        //String result = service.deleteAllVaccineByIds(List.of(2L,3L));
        //System.out.println(result);

        //CoronaVaccine cv1 = new CoronaVaccine();
        //cv1.setRegNo(53L);
        //CoronaVaccine cv2 = new CoronaVaccine();
        //cv2.setRegNo(50L);
        //String result = service.deleteAllVaccineRecords(List.of(cv1, cv2));
        //System.out.println(result);

        //String result = service.deleteAllVaccineRecords();
        //System.out.println(result);
    }*/

    //select or find methods of JPA repository
    /*@Override
    public void run(String... args) throws Exception {
        long vaccinesCount = service.getVaccinesCount();
        boolean isAvailable = service.vaccineAvailable(52);
        System.out.println(vaccinesCount);
        System.out.println(isAvailable);
        Iterable<CoronaVaccine> coronaVaccines = service.fetchAllVaccineDetails();
        coronaVaccines.forEach(vaccine -> System.out.println(String.valueOf(vaccine.getRegNo())));
        Iterable<CoronaVaccine> coronaVaccine = service.fetchVaccineByRegNo(List.of(52L, 2L));
        coronaVaccine.forEach(vaccine -> System.out.println(vaccine.getCompany()));
    }*/

    //bulk or batch inseriton
    /*@Override
    public void run(String... args) throws Exception {
        List<CoronaVaccine> coronaVaccines = List.of(new CoronaVaccine("sputnik", "russie", "Russia", 489.4, 2),
                new CoronaVaccine("pyzer", "pyzer", "USA", 478.4, 3),
                new CoronaVaccine("moderena", "moderena", "USA", 974.4, 1));
        Iterable<CoronaVaccine> coronaVaccines1 = service.registerBatch(coronaVaccines);
        for (CoronaVaccine vaccine : coronaVaccines1) {
            System.out.println(vaccine.getRegNo());
        }
    }*/

    //single record insertion
    @Override
    public void run(String... args) throws Exception {
        CoronaVaccine vaccine = new CoronaVaccine("covishield", "Serum", "India", 500.90, 1);
        String result = service.registerVaccine(vaccine);
        System.out.println(result);
    }
}
