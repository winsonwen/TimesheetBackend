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

    public Employee createEmployee(String phone, String firstName, String lastName, String email, String address, String picture, String password,
                                    String emergencyContact1Name, String emergencyContact1Phone,
                                    String emergencyContact2Name, String emergencyContact2Phone) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(email);
        if(optionalEmployee.isPresent()) {
            return null;
        } else {
            Employee employee = Employee.builder().firstName(firstName).lastName(lastName).phone(phone).email(email).
                    address(address).picture(picture).password(password).emergencyContact1Name(emergencyContact1Name).
                    emergencyContact1Phone(emergencyContact1Phone).emergencyContact2Name(emergencyContact2Name).
                    emergencyContact2Phone(emergencyContact2Phone).build();
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
