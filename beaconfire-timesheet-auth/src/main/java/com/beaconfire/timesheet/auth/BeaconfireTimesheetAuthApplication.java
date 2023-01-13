package com.beaconfire.timesheet.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableEurekaClient
public class BeaconfireTimesheetAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetAuthApplication.class, args);
    }

}
