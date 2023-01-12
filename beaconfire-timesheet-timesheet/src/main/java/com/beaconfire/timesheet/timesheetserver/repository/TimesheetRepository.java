package com.beaconfire.timesheet.timesheetserver.repository;


import com.beaconfire.timesheet.timesheetserver.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimesheetRepository extends MongoRepository<Timesheet, String> {

}
