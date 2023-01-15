package com.beaconfire.timesheet.employee.controller;

import com.beaconfire.timesheet.employee.domain.Employee;
import com.beaconfire.timesheet.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class ProfileController {

    EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    @CrossOrigin
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        Long id = Long.valueOf(1);
        Employee employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/update")
    @CrossOrigin
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.updateEmployee(employee);
        System.out.println(employee);
        return ResponseEntity.ok().body(employee);
    }
}
