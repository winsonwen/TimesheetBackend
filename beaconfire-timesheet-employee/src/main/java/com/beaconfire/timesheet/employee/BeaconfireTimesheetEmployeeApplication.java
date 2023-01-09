package com.beaconfire.timesheet.employee;

import com.beaconfire.timesheet.employee.domain.Employee;
import com.beaconfire.timesheet.employee.domain.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class BeaconfireTimesheetEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetEmployeeApplication.class, args);
    }



    @Bean
    ApplicationRunner applicationRunner(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee().builder()
                    .email("123@gmail.com")
                            .phone("123456")
                            .password("password")
                            .address("add")
                            .em1Lastname("l")
                    .build()
            );
        };
    }

}
