package com.ayush.repo;

import com.ayush.entity.CoronaVaccine;
import org.springframework.data.repository.CrudRepository;

public interface CoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {
}
