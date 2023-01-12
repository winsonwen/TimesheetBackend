package com.beaconfire.timesheet.timesheetserver.service;

import com.beaconfire.timesheet.timesheetserver.domain.Timesheet;
import com.beaconfire.timesheet.timesheetserver.repository.TimesheetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TimesheetService {

    TimesheetRepository timesheetRepository;

    TimesheetService(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }


    public void saveTimesheet(Timesheet timesheet) {
        Optional<Timesheet> byId = timesheetRepository.findById(timesheet.getId());
        if (byId.isPresent()) {
            timesheetRepository.delete(timesheet);
        }
        timesheetRepository.save(timesheet);
    }

    public Timesheet getTimesheetById(String generateTimesheetId) {
        Optional<Timesheet> byId = timesheetRepository.findById(generateTimesheetId);
      return byId.orElse(null);
    }
}
