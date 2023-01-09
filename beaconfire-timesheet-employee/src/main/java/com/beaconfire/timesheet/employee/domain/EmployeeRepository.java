package com.beaconfire.timesheet.employee.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {





//    public List<Employee> findByItem(String item);
//
//    @Query("SELECT e FROM Employee e WHERE e.amount >= :amount")
//    public List<Employee> listItemsWithPriceOver(@Param("amount") float amount);
}
