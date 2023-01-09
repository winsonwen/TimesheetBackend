package com.beaconfire.timesheet.timesheetserver;

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
