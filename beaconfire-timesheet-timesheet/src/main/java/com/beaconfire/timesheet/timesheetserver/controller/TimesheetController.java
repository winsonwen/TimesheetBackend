package com.beaconfire.timesheet.timesheetserver.controller;


import com.beaconfire.timesheet.timesheetserver.domain.Timesheet;
import com.beaconfire.timesheet.timesheetserver.domain.TimesheetRequest;
import com.beaconfire.timesheet.timesheetserver.service.TimesheetService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TimesheetController {

    private TimesheetService timesheetService;

    TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @PostMapping("/submit-timesheet")
    public ResponseEntity<String> saveTimesheet(@RequestBody TimesheetRequest timesheetRequest) {
        timesheetRequest.setEmployeeId(10);

        Timesheet timesheet = new Timesheet();
        BeanUtils.copyProperties(timesheetRequest, timesheet);
        timesheet.setId(generateTimesheetId(timesheet.getEmployeeId(), timesheet.getEndingDay()));
        timesheetService.saveTimesheet(timesheet);

        return new ResponseEntity<>("text", HttpStatus.OK);
    }


    @GetMapping("/timesheet")
    public ResponseEntity<Timesheet> getTimesheet( @PathParam("endingDay") Date endingDay) {
        Timesheet timesheetById = timesheetService.getTimesheetById(generateTimesheetId(10, endingDay));
        return new ResponseEntity<>(timesheetById, HttpStatus.OK);
    }

    private static String generateTimesheetId(int employeeId, Date endingDay) {
        return employeeId + "_" + new SimpleDateFormat("dd/MM/yyyy").format(endingDay);
    }
}
