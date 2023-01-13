package com.beaconfire.timesheet.timesheetserver.service;

import com.beaconfire.timesheet.timesheetserver.domain.OffDay;
import com.beaconfire.timesheet.timesheetserver.domain.OffDayCount;
import com.beaconfire.timesheet.timesheetserver.domain.Timesheet;
import com.beaconfire.timesheet.timesheetserver.domain.TimesheetDetail;
import com.beaconfire.timesheet.timesheetserver.repository.OffDayCountRepository;
import com.beaconfire.timesheet.timesheetserver.repository.TimesheetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class TimesheetService {

    TimesheetRepository timesheetRepository;

    OffDayCountRepository offDayCountRepository;

    TimesheetService(TimesheetRepository timesheetRepository, OffDayCountRepository offDayCountRepository) {
        this.timesheetRepository = timesheetRepository;
        this.offDayCountRepository = offDayCountRepository;
    }


    public boolean saveTimesheet(Timesheet timesheet) {
        Timesheet byId = timesheetRepository.findById(timesheet.getId()).orElse(null);
        OffDayCount offDayCount = offDayCountRepository.findById(String.valueOf(timesheet.getEmployeeId())).orElse(new OffDayCount(timesheet.getEmployeeId(), new HashMap<>()));
        Map<String, OffDay> yearOffDayMap = offDayCount.getYearOffDayMap();

        if (byId != null) {
            for (TimesheetDetail timesheetDetail : byId.getTimesheetDetails()) {
                int offDay = timesheetDetail.getOffDay();
                Calendar instance = Calendar.getInstance();
                instance.setTime(timesheetDetail.getDate());
                String year = String.valueOf(instance.get(Calendar.YEAR));
                OffDay offDay2 = yearOffDayMap.get(year);
                if (yearOffDayMap.get(year) == null) {
                    offDay2 = new OffDay();
                }

                if (offDay == 1) {
                    offDay2.setFloatingDay(offDay2.getFloatingDay() - 1);
                    yearOffDayMap.put(year, offDay2);

                } else if (offDay == 2) {
                    offDay2.setHoliday(offDay2.getHoliday() - 1);
                    yearOffDayMap.put(year, offDay2);
                } else if (offDay == 3) {
                    offDay2.setVacation(offDay2.getVacation() - +1);
                    yearOffDayMap.put(year, offDay2);
                }
            }
        }

        for (TimesheetDetail timesheetDetail : timesheet.getTimesheetDetails()) {
            int offDay = timesheetDetail.getOffDay();
            Calendar instance = Calendar.getInstance();
            instance.setTime(timesheetDetail.getDate());
            String year = String.valueOf(instance.get(Calendar.YEAR));
            OffDay offDay2 = yearOffDayMap.get(year);
            if (yearOffDayMap.get(year) == null) {
                offDay2 = new OffDay();
            }

            if (offDay == 1) {
                offDay2.setFloatingDay(offDay2.getFloatingDay() + 1);
                yearOffDayMap.put(year, offDay2);

            } else if (offDay == 2) {
                offDay2.setHoliday(offDay2.getHoliday() + 1);
                yearOffDayMap.put(year, offDay2);
            } else if (offDay == 3) {
                offDay2.setVacation(offDay2.getVacation() + +1);
                yearOffDayMap.put(year, offDay2);
            }
        }

        offDayCount.setYearOffDayMap(yearOffDayMap);
        if (isOffDayCountValid(offDayCount)) {
            offDayCountRepository.save(offDayCount);
            timesheetRepository.save(timesheet);
            return true;
        }else {
            return false;
        }
    }

    private boolean isOffDayCountValid(OffDayCount offDayCount) {
        return offDayCount.getYearOffDayMap().values().stream().allMatch((offDay -> offDay.getFloatingDay() <= 3 && offDay.getHoliday() <= 10 && offDay.getVacation() <= 3));
    }

    public Timesheet getTimesheetById(String generateTimesheetId) {
        Optional<Timesheet> byId = timesheetRepository.findById(generateTimesheetId);
        return byId.orElse(null);
    }
}
