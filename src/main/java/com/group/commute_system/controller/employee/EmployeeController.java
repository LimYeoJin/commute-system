package com.group.commute_system.controller.employee;

import com.group.commute_system.dto.employee.request.EmployeeCreateRequest;
import com.group.commute_system.dto.employee.request.WorkLogCreateRequest;
import com.group.commute_system.dto.employee.response.EmployeeResponse;
import com.group.commute_system.dto.employee.response.WorkLogResponse;
import com.group.commute_system.service.employee.EmployeeService;
import com.group.commute_system.service.employee.WorkLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final WorkLogService workLogService;


    /*
        직원 등록
     */
    @PostMapping
    public void saveEmployee(@RequestBody EmployeeCreateRequest request) {
        employeeService.saveEmployee(request);
    }

    /*
        직원 조회
     */
    @GetMapping
    public List<EmployeeResponse> getEmployees() {
        return employeeService.getEmployees();
    }

    /*
        직원 출근
     */
    @PostMapping("/worklogs")
    public void saveWorkLog(@RequestBody WorkLogCreateRequest request) {
        workLogService.saveWorkLog(request);
    }

    /*
        직원 퇴근
     */
    @PutMapping("/worklogs")
    public void updateWorkLog(@RequestParam(name = "employeeId") long id) {
        workLogService.updateWorkLog(id);
    }

    /*
        특정 직원의 날짜별 근무시간 조회
     */
    @GetMapping("/worklogs/{employeeId}/details/{yearMonth}")
    public WorkLogResponse getWorkLogDetails(@PathVariable(name="employeeId") long employeeId,
                                             @PathVariable(name="yearMonth") YearMonth yearMonth) {
        return workLogService.getWorkLogDetails(employeeId, yearMonth);
    }
}
