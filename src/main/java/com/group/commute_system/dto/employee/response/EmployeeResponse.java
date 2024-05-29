package com.group.commute_system.dto.employee.response;

import com.group.commute_system.domain.employee.Employee;
import com.group.commute_system.domain.employee.Role;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class EmployeeResponse {

    private String name;
    private String teamName;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;


    public EmployeeResponse(Employee employee) {
        this.name = employee.getName();
        this.teamName = employee.getTeam().getName();
        this.role = (employee.isManager()) ? Role.MANAGER : Role.MEMBER;
        this.birthday = employee.getBirthday();
        this.workStartDate = employee.getWorkStartDate();
    }

}
