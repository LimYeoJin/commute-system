package com.group.commute_system.dto.employee.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeCreateRequest {
    private String name;
    private String teamName;
    private boolean isManager;
    private LocalDate workStartDate;
    private LocalDate birthday;

    public boolean getIsManager() {
        return isManager;
    }
}
