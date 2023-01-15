package com.beaconfire.timesheet.timesheetserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SummaryResponse {
    private String id;
    private String  employeeId;
    private Date endingDay;
    private List<TimesheetDetail> timesheetDetails;
    private int isSubmit;
    private int approvalStatus;
    private String file;
    private int floatingDayOfYear;
    private int holidayOfYear;
    private int vacationOfYear;
}
