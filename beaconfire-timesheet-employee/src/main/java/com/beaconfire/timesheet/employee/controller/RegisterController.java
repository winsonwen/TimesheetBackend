package com.beaconfire.timesheet.employee.controller;

import com.beaconfire.timesheet.employee.domain.Employee;
import com.beaconfire.timesheet.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<Object> register(@RequestBody Employee employee) {

        System.out.println("register!!! " + employee.getEmail());
        Employee newEmployee = employeeService.createEmployee(employee);
        if (newEmployee == null) {
            System.out.println("Email was used!");
            return ResponseEntity.badRequest().body("Email was used! Please try another one");
        }

        return ResponseEntity.ok().body(employee);
    }
}
