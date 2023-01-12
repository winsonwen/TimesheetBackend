package com.beaconfire.timesheet.timesheetserver.repository;


import com.beaconfire.timesheet.timesheetserver.domain.TimesheetFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimesheetFileRepository extends MongoRepository<TimesheetFile, String>  {

}
