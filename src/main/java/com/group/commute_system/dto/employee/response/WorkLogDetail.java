package com.group.commute_system.dto.employee.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class WorkLogDetail {
    private LocalDate date;
    private long workingMinutes;

    public WorkLogDetail(LocalDate date, long workingMinutes) {
        this.date = date;
        this.workingMinutes = workingMinutes;
    }
}
