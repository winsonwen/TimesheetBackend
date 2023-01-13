package com.beaconfire.timesheet.timesheetserver.repository;


import com.beaconfire.timesheet.timesheetserver.domain.OffDayCount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OffDayCountRepository extends MongoRepository<OffDayCount, String> {

}
