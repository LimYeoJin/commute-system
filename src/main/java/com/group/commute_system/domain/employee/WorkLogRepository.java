package com.group.commute_system.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WorkLogRepository extends JpaRepository<WorkLog, Long> {
    boolean existsByEmployeeIdAndDate(long id, LocalDate now);
    Optional<WorkLog> findByEmployeeIdAndDate(long employeeId, LocalDate now);
}
