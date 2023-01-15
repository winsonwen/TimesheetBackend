package com.beaconfire.timesheet.timesheetserver.controller;


import com.beaconfire.timesheet.timesheetserver.domain.SummaryResponse;
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
import java.util.Objects;
import java.util.List;

@RestController
public class TimesheetController {

    private TimesheetService timesheetService;

    TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @PostMapping("/submit-timesheet")
    public ResponseEntity<Object> saveTimesheet(@RequestBody TimesheetRequest timesheetRequest) {
        timesheetRequest.setEmployeeId("10");

        Timesheet timesheet = new Timesheet();
        BeanUtils.copyProperties(timesheetRequest, timesheet);
        timesheet.setId(generateTimesheetId(timesheet.getEmployeeId(), timesheet.getEndingDay()));
       if( timesheetService.saveTimesheet(timesheet )){
           return new ResponseEntity<>("Successful", HttpStatus.OK);
       }else{
           return new ResponseEntity<>("Please check your Off Day", HttpStatus.BAD_REQUEST);
       }

    }


    @GetMapping("/timesheet")
    public ResponseEntity<Timesheet> getTimesheet( @PathParam("endingDay") Date endingDay) {
        Timesheet timesheetById = timesheetService.getTimesheetById(generateTimesheetId("10", endingDay));
        return new ResponseEntity<>(timesheetById, HttpStatus.OK);
    }

    private static String generateTimesheetId(String employeeId, Date endingDay) {
        return employeeId + "_" + new SimpleDateFormat("dd/MM/yyyy").format(endingDay);
    }

    @GetMapping("/")
    public ResponseEntity<List<SummaryResponse>> getAllTimesheets()
    {
        return new ResponseEntity<>(timesheetService.getAllTimesheets(), HttpStatus.OK);
    }

}
