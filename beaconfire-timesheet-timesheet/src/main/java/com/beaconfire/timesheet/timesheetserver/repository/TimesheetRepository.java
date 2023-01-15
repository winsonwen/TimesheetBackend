package com.beaconfire.timesheet.timesheetserver.repository;


import com.beaconfire.timesheet.timesheetserver.domain.Timesheet;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TimesheetRepository extends MongoRepository<Timesheet, String> {
    List<Timesheet> findByEmployeeId(String eid, Sort sort);
}
