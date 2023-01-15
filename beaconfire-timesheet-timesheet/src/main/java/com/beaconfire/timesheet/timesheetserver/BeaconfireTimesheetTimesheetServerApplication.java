package com.beaconfire.timesheet.timesheetserver;

import com.beaconfire.timesheet.timesheetserver.domain.TimesheetFile;
import com.beaconfire.timesheet.timesheetserver.repository.TimesheetFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeaconfireTimesheetTimesheetServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetTimesheetServerApplication.class, args);
    }





}
