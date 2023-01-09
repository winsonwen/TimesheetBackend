package com.beaconfire.timesheet.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeaconfireTimesheetEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetEmployeeApplication.class, args);
    }

}
