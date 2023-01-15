package com.beaconfire.timesheet.employee.dao;

import com.beaconfire.timesheet.employee.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByEmail(@Nullable String email);



}
