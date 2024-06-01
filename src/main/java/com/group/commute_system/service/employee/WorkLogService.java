package com.group.commute_system.service.employee;

import com.group.commute_system.domain.employee.Employee;
import com.group.commute_system.domain.employee.EmployeeRepository;
import com.group.commute_system.domain.employee.WorkLog;
import com.group.commute_system.domain.employee.WorkLogRepository;
import com.group.commute_system.dto.employee.request.WorkLogCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WorkLogService {
    private final WorkLogRepository workLogRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Employee checkEmployee(long id) {
        // 등록된 직원인지 확인
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("[%s] employee does not exists!", id)));
    }

    @Transactional
    public void saveWorkLog(WorkLogCreateRequest request) {
        Employee employee = checkEmployee(request.getEmployeeId());
        // 이미 출근한 직원인지 확인
        if (workLogRepository.existsByEmployeeIdAndDate(employee.getId(), LocalDate.now())) {
            throw new IllegalArgumentException(String.format("[%s] employee has already arrived at work.", request.getEmployeeId()));
        }

        LocalDateTime now = request.getCheckInTime() == null? LocalDateTime.now() : request.getCheckInTime();
        workLogRepository.save(new WorkLog(employee,now));
    }

    @Transactional
    public void updateWorkLog(long id) {
        Employee employee = checkEmployee(id);
        // 퇴근하려는 직원이 출근하지 않았던 경우
        if (!workLogRepository.existsByEmployeeIdAndDate(employee.getId(), LocalDate.now())) {
            throw new IllegalArgumentException(String.format("[%s] employee who did not show up for work.", employee.getId()));
        }

        WorkLog workLog = workLogRepository.findByEmployeeIdAndDate(employee.getId(), LocalDate.now())
                .stream()
                .filter(checkOutTime -> checkOutTime.getCheckOutTime() == null)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("[%s] employee has already left work.", employee.getId())));

        workLog.doLeaveWork();
    }


}
