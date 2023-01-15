package com.beaconfire.timesheet.timesheetserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OffDayCount {
    @Id
    private String id;

    private Map<String, OffDay> yearOffDayMap;


}

