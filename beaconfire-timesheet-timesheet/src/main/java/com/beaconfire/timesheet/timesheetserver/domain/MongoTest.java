package com.beaconfire.timesheet.timesheetserver.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document
public class MongoTest {
	
	@Id
	private String id;
	private String name;
}
