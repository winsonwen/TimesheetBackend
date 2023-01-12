package com.beaconfire.timesheet.timesheetserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimesheetDetail {
    private Date date;
    private Date startTime;

    private Date endTime;

    private int totalHours;
    private int offDay;  //   0 not selected,  1 floating day,2 holiday,  3 vacation

}
