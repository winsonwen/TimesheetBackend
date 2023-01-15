package com.beaconfire.timesheet.employee.service;

import com.beaconfire.timesheet.employee.dao.EmployeeRepository;
import com.beaconfire.timesheet.employee.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employee.getEmail());
        if(optionalEmployee.isPresent()) {
            return null;
        } else {
            Long userId = employeeRepository.save(employee).getId();
            //TODO: create JwtModel here or not?

            return employee;
        }

    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
