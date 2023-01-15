package com.beaconfire.timesheet.employee;

import com.beaconfire.timesheet.employee.domain.Employee;
import com.beaconfire.timesheet.employee.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeaconfireTimesheetEmployeeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BeaconfireTimesheetEmployeeApplication.class, args);
    }



    //Test
    @Autowired
    EmployeeRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Iterable<Employee> iterator = repository.findAll();
        iterator.forEach(e -> System.out.println(e.getEmail()));
    }
}
