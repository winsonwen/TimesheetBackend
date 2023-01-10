package com.beaconfire.timesheet.timesheetserver.repository;


import com.beaconfire.timesheet.timesheetserver.domain.MongoTest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoTestRepository extends MongoRepository<MongoTest, String>  {

}
