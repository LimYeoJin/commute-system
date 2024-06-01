package com.group.commute_system.service.employee;

import com.group.commute_system.domain.employee.Employee;
import com.group.commute_system.domain.employee.EmployeeRepository;
import com.group.commute_system.domain.team.Team;
import com.group.commute_system.domain.team.TeamRepository;
import com.group.commute_system.dto.employee.request.EmployeeCreateRequest;
import com.group.commute_system.dto.employee.response.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void saveEmployee(EmployeeCreateRequest request) {
        if (!teamRepository.existsByName(request.getTeamName())) {
            throw new IllegalArgumentException(String.format("[%s] team does not exists!", request.getTeamName()));
        }
        Team team = teamRepository.findByName(request.getTeamName())
                        .orElseThrow(IllegalArgumentException::new);

        employeeRepository.save(new Employee(request.getName(),
                request.getIsManager(),
                request.getWorkStartDate(),
                request.getBirthday(),
                team));
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> getEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeResponse::new)
                .collect(Collectors.toList());
    }



}
