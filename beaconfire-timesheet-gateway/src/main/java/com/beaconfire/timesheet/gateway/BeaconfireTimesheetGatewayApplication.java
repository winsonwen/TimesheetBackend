package com.beaconfire.timesheet.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeaconfireTimesheetGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetGatewayApplication.class, args);
    }

}
