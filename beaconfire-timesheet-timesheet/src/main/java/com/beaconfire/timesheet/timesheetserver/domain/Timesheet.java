package com.beaconfire.timesheet.timesheetserver.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document
public class Timesheet {

    @Id
    private String id;

    private String  employeeId;

    private Date endingDay;

    List<TimesheetDetail> timesheetDetails;

    private int isSubmit; // 0 not submitted   1 submitted
    private int approvalStatus;//     – not available 0, not approved 1, approved 2)

    private String file;

}
