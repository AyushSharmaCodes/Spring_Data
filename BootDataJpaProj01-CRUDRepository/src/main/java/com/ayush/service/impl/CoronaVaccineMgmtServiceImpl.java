package com.ayush.service.impl;

import com.ayush.entity.CoronaVaccine;
import com.ayush.repo.CoronaVaccineRepo;
import com.ayush.service.CoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements CoronaVaccineMgmtService {

    private final CoronaVaccineRepo vaccineRepo;

    public CoronaVaccineMgmtServiceImpl(@Autowired CoronaVaccineRepo vaccineRepo){
        this.vaccineRepo=vaccineRepo;
    }

    @Override
    public String registerVaccine(CoronaVaccine vaccine) {
        CoronaVaccine registeredVaccine = null;
        if(vaccine != null) {
            registeredVaccine = vaccineRepo.save(vaccine);
        }
        return registeredVaccine != null ? "Vaccine registered/updated with "+registeredVaccine.getRegNo() : "Vaccine registration/update failed";
    }

    @Override
    public Iterable<CoronaVaccine> registerBatch(Iterable<CoronaVaccine> vaccines) {
        if (vaccines != null) {
            return vaccineRepo.saveAll(vaccines);
        }
        else {
            throw new IllegalArgumentException("Batch insertion failed");
        }
    }

    @Override
    public long getVaccinesCount() {
        return vaccineRepo.count();
    }

    @Override
    public boolean vaccineAvailable(long regNo) {
        return vaccineRepo.existsById(regNo);
    }

    @Override
    public Iterable<CoronaVaccine> fetchAllVaccineDetails() {
        return vaccineRepo.findAll();
    }

    @Override
    public Iterable<CoronaVaccine> fetchVaccineByRegNo(Iterable<Long> regNo) {
        return vaccineRepo.findAllById(regNo);
    }

    @Override
    public String deleteVaccineById(Long regNo) {
        Optional<CoronaVaccine> vaccine = vaccineRepo.findById(regNo);
        if(vaccine.isPresent()){
            vaccineRepo.deleteById(vaccine.get().getRegNo());
            return "Vaccine Successfully Deleted By Id!";
        }else {
            return "Vaccine Not Found";
        }
    }

    @Override
    public String deleteVaccineRecord(CoronaVaccine vaccine) {
        Optional<CoronaVaccine> record = vaccineRepo.findById(vaccine.getRegNo());
        if(record.isPresent()){
            vaccineRepo.delete(record.get());
            return "Vaccine details Deleted Successfully!";
        }else {
            return "Vaccine Not Found";
        }
    }

    @Override
    public String deleteAllVaccineByIds(Iterable<Long> regNos) {
        Iterable<CoronaVaccine> records = vaccineRepo.findAllById(regNos);
        List<CoronaVaccine> vaccines = StreamSupport
                .stream(records.spliterator(), false)
                .toList();
        if(!vaccines.isEmpty()){
            vaccineRepo.deleteAllById(regNos);
            return "All Vaccine of provided Ids Successfully Deleted!";
        }else {
            return "Vaccines Not Found";
        }
    }

    @Override
    public String deleteAllVaccineRecords(Iterable<CoronaVaccine> vaccines) {
        List<Long> regNos = StreamSupport.stream(vaccines.spliterator(), false)
                .map(CoronaVaccine::getRegNo)
                .toList();

        List<CoronaVaccine> existingVaccines = StreamSupport
                .stream(vaccineRepo.findAllById(regNos).spliterator(), false)
                .toList();

        if (!existingVaccines.isEmpty()) {
            vaccineRepo.deleteAll(existingVaccines);
            return "All provided Vaccine records are Successfully Deleted! with total count"+existingVaccines.size();
        } else {
            return "Vaccines Not Found";
        }
    }

    @Override
    public String deleteAllVaccineRecords() {
        Iterable<CoronaVaccine> fetchedRecords = vaccineRepo.findAll();
        List<CoronaVaccine> vaccines = StreamSupport.stream(fetchedRecords.spliterator(), false).toList();
        if(!vaccines.isEmpty()){
            vaccineRepo.deleteAll();
            return vaccines.size()+"Vaccine records are Deleted Successfully!";
        } else {
            return "Vaccines records are empty";
        }
    }
}
