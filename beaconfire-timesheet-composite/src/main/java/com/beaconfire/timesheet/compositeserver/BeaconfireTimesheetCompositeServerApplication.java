package com.beaconfire.timesheet.compositeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeaconfireTimesheetCompositeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetCompositeServerApplication.class, args);
    }

}
