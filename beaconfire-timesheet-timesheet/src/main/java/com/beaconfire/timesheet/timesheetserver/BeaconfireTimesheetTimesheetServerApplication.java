package com.beaconfire.timesheet.timesheetserver;

import com.beaconfire.timesheet.timesheetserver.domain.MongoTest;
import com.beaconfire.timesheet.timesheetserver.repository.MongoTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class BeaconfireTimesheetTimesheetServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetTimesheetServerApplication.class, args);
    }



    //Test
    @Autowired
    private MongoTestRepository mongoTestRepository;
    @Override
    public void run(String... args) throws Exception {
        Iterable<MongoTest> iterator = mongoTestRepository.findAll();
        iterator.forEach(e -> System.out.println(e.getName()));
    }

}
