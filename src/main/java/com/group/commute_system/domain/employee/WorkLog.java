package com.group.commute_system.domain.employee;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private LocalDate date;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public WorkLog(Employee employee, LocalDateTime checkInTime) {
        this.employee = employee;
        this.date = LocalDate.now();
        this.checkInTime = checkInTime;
    }

    public void doLeaveWork() {
        this.checkOutTime = LocalDateTime.now() ;
    }

}
