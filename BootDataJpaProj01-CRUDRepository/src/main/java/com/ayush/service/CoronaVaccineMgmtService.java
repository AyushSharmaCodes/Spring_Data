package com.ayush.service;

import com.ayush.entity.CoronaVaccine;

public interface CoronaVaccineMgmtService {

    String registerVaccine(CoronaVaccine vaccine);
    Iterable<CoronaVaccine> registerBatch(Iterable<CoronaVaccine> vaccines);
}
