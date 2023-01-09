package com.beaconfire.timesheet.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeaconfireTimesheetAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetAuthApplication.class, args);
    }

}
