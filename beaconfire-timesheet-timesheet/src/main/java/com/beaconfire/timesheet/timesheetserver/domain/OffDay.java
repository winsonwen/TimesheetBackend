package com.beaconfire.timesheet.timesheetserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OffDay {
    private int floatingDay;
    private int holiday;
    private int vacation;
}
