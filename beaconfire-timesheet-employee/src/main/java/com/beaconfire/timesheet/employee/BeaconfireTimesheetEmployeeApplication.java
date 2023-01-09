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
//            repository.save(new Employee("breakfast", 5));
//            repository.save(new Employee("coffee", 2));
//            repository.save(new Employee("New SSD drive", 200));
//            repository.save(new Employee("Tution for baby", 350));
//
//            Iterable<Employee> iterator = repository.findAll();
//
//            System.out.println("All expense items: ");
//            iterator.forEach(item -> System.out.println(item));
//
//            List<Employee> breakfast = repository.findByItem("breakfast");
//            System.out.println("\nHow does my breakfast cost?: ");
//            breakfast.forEach(item -> System.out.println(item));
//
//            List<Employee> expensiveItems = repository.listItemsWithPriceOver(200);
//            System.out.println("\nExpensive Items: ");
//            expensiveItems.forEach(item -> System.out.println(item));
        };
    }

}
