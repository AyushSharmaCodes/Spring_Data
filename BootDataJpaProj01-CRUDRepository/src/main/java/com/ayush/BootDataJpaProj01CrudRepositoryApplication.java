package com.ayush;

import com.ayush.entity.CoronaVaccine;
import com.ayush.service.CoronaVaccineMgmtService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootDataJpaProj01CrudRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDataJpaProj01CrudRepositoryApplication.class, args);

          //below code is not recommended to write here for testing it can be written in runner class

//        ApplicationContext ctx = SpringApplication.run(BootDataJpaProj01CrudRepositoryApplication.class, args);
//        CoronaVaccineMgmtService vaccineMgmtService = ctx.getBean("vaccineMgmtService", CoronaVaccineMgmtService.class);
//        CoronaVaccine vaccine = new CoronaVaccine("covaxin", "Bharat-Biotech", "India", 780.02, 2);
//        String result = vaccineMgmtService.registerVaccine(vaccine);
//        System.out.println(result);
    }

}
