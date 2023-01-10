package com.beaconfire.timesheet.employee.controller;

import com.beaconfire.timesheet.employee.domain.Employee;
import com.beaconfire.timesheet.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/employee")
public class ProfileController {

    EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<Employee> getEmployee() {
        return null;
    }
}
