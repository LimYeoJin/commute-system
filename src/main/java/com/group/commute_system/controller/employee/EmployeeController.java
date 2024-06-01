package com.group.commute_system.controller.employee;

import com.group.commute_system.dto.employee.request.EmployeeCreateRequest;
import com.group.commute_system.dto.employee.request.WorkLogCreateRequest;
import com.group.commute_system.dto.employee.response.EmployeeResponse;
import com.group.commute_system.service.employee.EmployeeService;
import com.group.commute_system.service.employee.WorkLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final WorkLogService workLogService;


    @PostMapping
    public void saveEmployee(@RequestBody EmployeeCreateRequest request) {
        employeeService.saveEmployee(request);
    }

    @GetMapping
    public List<EmployeeResponse> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/workLog")
    public void saveWorkLog(@RequestBody WorkLogCreateRequest request) {
        workLogService.saveWorkLog(request);
    }

    @PutMapping("/workLog")
    public void updateWorkLog(@RequestParam(name = "employeeId") long id) {
        workLogService.updateWorkLog(id);
    }
}
