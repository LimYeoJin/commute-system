package com.group.commute_system.dto.team.response;

import com.group.commute_system.domain.employee.Employee;
import com.group.commute_system.domain.team.Team;
import lombok.Getter;

@Getter
public class TeamResponse {
    private String name;
    private String manager;
    private int memberCount;

    public TeamResponse(Team team) {
        this.name = team.getName();
        this.manager = getManagerName(team);
        this.memberCount = team.getEmployeeList().size();
    }
    public String getManagerName(Team team) {
        return team.getEmployeeList().stream()
                .filter(employee -> employee.isManager() == true)
                .map(Employee::getName)
                .findFirst()
                .orElse(null);
    }
}
