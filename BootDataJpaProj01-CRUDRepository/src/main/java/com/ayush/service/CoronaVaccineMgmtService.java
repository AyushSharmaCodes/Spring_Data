package com.ayush.service;

import com.ayush.entity.CoronaVaccine;

public interface CoronaVaccineMgmtService {

    String registerVaccine(CoronaVaccine vaccine);
    Iterable<CoronaVaccine> registerBatch(Iterable<CoronaVaccine> vaccines);

    long getVaccinesCount();
    boolean vaccineAvailable(long regNo);
    Iterable<CoronaVaccine> fetchAllVaccineDetails();
    Iterable<CoronaVaccine> fetchVaccineByRegNo(Iterable<Long> regNo);

    String deleteVaccineById(Long regNo);
    String deleteVaccineRecord(CoronaVaccine vaccine);
    String deleteAllVaccineByIds(Iterable<Long> regNos);
    String deleteAllVaccineRecords(Iterable<CoronaVaccine> vaccines);
    String deleteAllVaccineRecords();
}
